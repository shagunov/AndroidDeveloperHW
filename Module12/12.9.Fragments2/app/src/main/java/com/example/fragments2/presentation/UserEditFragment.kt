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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragments2.R
import com.example.fragments2.UserListApplication
import com.example.fragments2.databinding.FragmentUserDetailsBinding
import com.example.fragments2.databinding.FragmentUserEditBinding
import com.example.fragments2.model.User
import com.example.fragments2.model.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserEditFragment : Fragment() {

    private var binding: FragmentUserEditBinding? = null

    private val args: UserEditFragmentArgs by navArgs()

    private val viewModel: UserEditViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {binding = FragmentUserEditBinding.inflate(inflater, container, false)
        viewModel.fetchUser()

        binding?.let{ with(it){

            viewModel.userDetailFlow.value.let { user ->
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
                viewModel.submitUser()
            }

            lifecycleScope.launch {
                viewModel.backEvent.collect {
                    findNavController().popBackStack()
                }
            }
        }}

        return binding?.root
    }
}