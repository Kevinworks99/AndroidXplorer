package com.adroid.androidxplorer.components.screens.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.adroid.androidxplorer.components.screens.signup.Signup
import com.adroid.androidxplorer.databinding.ActivitySplashscreenBinding

@SuppressLint("CustomSplashScreen")
class Splashscreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Signup::class.java))
            finish()
        }, 2000)
    }

}