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
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UserEditFragment : Fragment() {

    private var binding: FragmentUserEditBinding? = null

    private val viewModel: UserEditViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {binding = FragmentUserEditBinding.inflate(inflater, container, false)

        binding?.let{ with(it){

            lifecycleScope.launch{
                viewModel.fetchJob.join()
                viewModel.userFormState.value.apply {
                    nameEditText.setText(name)
                    lastNameEditText.setText(lastName)
                    phoneNumberEditText.setText(phoneNumber)
                    emailEditText.setText(email)
                    countryEditText.setText(country)
                    cityEditText.setText(city)
                    aboutHimselfEditText.setText(himself)
                }
            }

            nameEditText.doAfterTextChanged { value -> viewModel.userNameChanged(value.toString()) }
            lastNameEditText.doAfterTextChanged { value -> viewModel.userLastNameChanged(value.toString()) }
            phoneNumberEditText.doAfterTextChanged { value -> viewModel.userPhoneNumberChanged(value.toString()) }
            emailEditText.doAfterTextChanged { value -> viewModel.userEmailChanged(value.toString()) }
            countryEditText.doAfterTextChanged { value -> viewModel.userCountryChanged(value.toString()) }
            cityEditText.doAfterTextChanged { value -> viewModel.userCityChanged(value.toString()) }
            aboutHimselfEditText.doAfterTextChanged { value -> viewModel.userHimselfChanged(value.toString()) }

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