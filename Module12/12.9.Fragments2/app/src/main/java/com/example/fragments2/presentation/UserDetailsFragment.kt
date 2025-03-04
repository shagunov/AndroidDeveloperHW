package com.example.fragments2.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.fragments2.UserListApplication
import com.example.fragments2.databinding.FragmentUserDetailsBinding
import kotlinx.coroutines.launch

class UserDetailsFragment : Fragment(), MenuProvider {

    private val viewModel: UserDetailsViewModel by viewModels{
        UserDetailsViewModelFactory(UserListApplication.instance.repository, requireArguments().getInt("userID"))
    }
    private var binding: FragmentUserDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)

        binding?.let{

            lifecycleScope.launch {
                viewModel.fetchUser()
                viewModel.userDetailFlow
                    .collect { user ->
                        it.nameTextView.text = user?.name
                        it.lastNameTextView.text = user?.lastName
                        it.phoneNumberTextView.text = user?.phoneNumber
                        it.emailTextView.text = user?.email
                        it.countryTextView.text = user?.country
                        it.cityTextView.text = user?.city
                        it.aboutHimselfTextView.text = user?.himself
                    }
            }
        }

        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int): UserDetailsFragment = UserDetailsFragment().apply{
            arguments = Bundle().apply {
                putInt("userID", id)
            }
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        TODO("Not yet implemented")
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}