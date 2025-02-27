package com.example.viewmodel

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.viewmodel.databinding.ActivityRepositoryBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoryActivity : AppCompatActivity() {

    private val viewModel : RepositoryViewModel by viewModels()
    private var binding: ActivityRepositoryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ArrayAdapter(this, android.R.layout.simple_list_item_1, viewModel.productList).also {
            binding!!.ProductsLV.adapter = it

            lifecycleScope.launch {
                while (true){
                    viewModel.updateNotify.collect { _ -> it.notifyDataSetChanged() }
                }
            }
        }

        with(binding!!.LoadBTN){
            setOnClickListener {
                viewModel.clearList()

                lifecycleScope.launch(Dispatchers.IO) {
                    viewModel.loadProducts()
                }
            }
        }
    }
}