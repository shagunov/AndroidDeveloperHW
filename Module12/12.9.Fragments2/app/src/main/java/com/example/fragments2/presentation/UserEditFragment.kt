package com.example.fragments2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.fragments2.R
import com.example.fragments2.UserListApplication
import com.example.fragments2.databinding.FragmentUserDetailsBinding
import com.example.fragments2.databinding.FragmentUserEditBinding
import com.example.fragments2.model.User
import com.example.fragments2.model.UserRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserEditFragment : Fragment() {

    private var binding: FragmentUserEditBinding? = null
    private val viewModel: UserEditViewModel by viewModels{
        UserEditViewModelFactory(UserListApplication.instance.repository, requireArguments().getInt("userID"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {binding = FragmentUserEditBinding.inflate(inflater, container, false)

        binding?.let{ with(it){

            viewModel.userDetailFlow.value?.let { user ->
                nameEditText.setText(user.name)
                lastNameEditText.setText(user.lastName)
                phoneNumberEditText.setText(user.phoneNumber)
                emailEditText.setText(user.email)
                countryEditText.setText(user.country)
                cityEditText.setText(user.city)
                aboutHimselfEditText.setText(user.himself)
            }

            nameEditText.doAfterTextChanged { value -> viewModel.userNameChanged(value.toString()) }
            lastNameEditText.doAfterTextChanged { value -> viewModel.userLastNameChanged(value.toString()) }
            phoneNumberEditText.doAfterTextChanged { value -> viewModel.userPhoneNumberChanged(value.toString()) }
            emailEditText.doAfterTextChanged { value -> viewModel.userEmailChanged(value.toString()) }
            countryEditText.doAfterTextChanged { value -> viewModel.userCountryChanged(value.toString()) }
            cityEditText.doAfterTextChanged { value -> viewModel.userCityChanged(value.toString()) }
            aboutHimselfEditText.doAfterTextChanged { value -> viewModel.userHimselfChanged(value.toString()) }
            dateBirthEditText.doAfterTextChanged { value -> viewModel.userDateBirthChanged(value.toString()) }

            submitButton.setOnClickListener { _ ->
                lifecycleScope.launch {
                    viewModel.submitUser()
                }
            }

            lifecycleScope.launch {
                viewModel.fetchUser()
            }
        }}

        return binding?.root
    }

    companion object {

        @JvmStatic
        fun newInstance(id: Int = -1) = UserEditFragment().apply {
            arguments = Bundle().apply {
                putInt("userID", id)
            }
        }
    }
}