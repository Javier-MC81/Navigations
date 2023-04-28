package com.jmoreno.navigations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jmoreno.navigations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val personaje=  Personaje("Goku", 30)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvOpenNewActivity.setOnClickListener {
            SecondActivity.launch(this,"Hola",10, personaje)


        }
    }
}