package com.example.capstoneproject.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivityMainBinding
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.adapter.HistoryAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private var username: String? = null
    private val adapter = HistoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getSession().observe(this){
            username = it
        }

        username?.let { mainViewModel.history(it) }

        binding.trashRv.layoutManager = LinearLayoutManager(this)
        binding.trashRv.setHasFixedSize(true)
        mainViewModel.getListImagesItem().observe(this){
            adapter.setData(it)
        }
    }
}