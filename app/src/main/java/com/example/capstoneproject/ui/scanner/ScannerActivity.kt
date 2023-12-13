package com.example.capstoneproject.ui.scanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivityScannerBinding
import com.example.capstoneproject.ui.main.MainActivity
import com.example.capstoneproject.ui.profile.ProfileActivity

class ScannerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScannerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.navView.setOnClickListener { menuItem ->
            when (menuItem.id) {
                R.id.navigation_home-> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                R.id.navigation_scan->{
                    startActivity(Intent(this, ScannerActivity::class.java))
                }
                else -> false
            }
        }
    }
}