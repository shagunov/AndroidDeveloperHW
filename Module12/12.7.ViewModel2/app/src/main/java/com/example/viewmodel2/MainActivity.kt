package com.example.viewmodel2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.transition.Visibility
import com.example.viewmodel2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val viewModel: MyModelView by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            viewModel.uiState.collect{
                when (it){
                    is UiState.Initial -> {
                        binding!!.apply{
                            resultTV.visibility = View.GONE
                            progressBar.visibility = View.GONE
                        }
                    }
                    is UiState.Error -> {
                        binding!!.apply{
                            resultTV.visibility = View.GONE
                            progressBar.visibility = View.GONE
                        }
                        Snackbar.make(binding!!.root, it.cause, Snackbar.LENGTH_LONG).show()
                    }
                    is UiState.Loading -> {
                        binding!!.apply{
                            resultTV.visibility = View.GONE
                            progressBar.visibility = View.VISIBLE
                        }
                    }
                    is UiState.Success -> {
                        binding!!.apply {
                            resultTV.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                            resultTV.text = it.result
                        }
                    }
                }
            }
        }

        with(binding!!.loadData){
            setOnClickListener {
                viewModel.fetchData()
            }
        }
    }
}