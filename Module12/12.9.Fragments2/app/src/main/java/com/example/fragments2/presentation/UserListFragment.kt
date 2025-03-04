package com.example.fragments2.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragments2.R
import com.example.fragments2.UserListApplication
import com.example.fragments2.databinding.FragmentUserListBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserListFragment : Fragment() {

    private var binding: FragmentUserListBinding? = null
    private val viewModel: UserListViewModel by viewModels{
        UserListViewModelFactory(UserListApplication.instance.repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        binding?.let{ bind -> with(bind) {

            userList.apply {
                adapter = UserListAdapter(viewModel.userList,
                    onItemClickListener = { position -> viewModel.seeUserDetails(position) },
                    onDeleteUserEventListener = { position -> viewModel.deleteUser(position) },
                    onEditUserEventListener = { position -> viewModel.editUser(position) }
                )
                layoutManager = LinearLayoutManager(requireContext())
            }

            val navigator = findNavController()

            lifecycleScope.launch {
                viewModel.fetchData()
                viewModel.navigationEvent.collectLatest{
                    when(it){
                        is UserListNavEvent.NewUser -> {
                            //navigate to UserEditFragment with param -1
                            val action = UserListFragmentDirections.actionUserListFragmentToUserEditFragment(-1)
                            navigator.navigate(action)
                        }
                        is UserListNavEvent.EditUser -> {
                            //navigate to UserEditFragment with param it.position
                            val action = UserListFragmentDirections.actionUserListFragmentToUserEditFragment(it.position)
                            navigator.navigate(action)
                        }
                        is UserListNavEvent.UserDetails -> {
                            //navigate to UserDetailsFragment with param it.position
                            val action = UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(it.position)
                            navigator.navigate(action)
                        }
                        null -> {}
                    }
                }
            }
        }}

        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = UserListFragment()
    }
}