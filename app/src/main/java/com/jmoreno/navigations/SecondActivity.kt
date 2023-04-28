package com.jmoreno.navigations

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.google.gson.Gson
import com.jmoreno.navigations.databinding.ActivityMainBinding
import com.jmoreno.navigations.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    companion object {

        const val TAG_STRING = "TAG_STRING"
        const val TAG_NUM = "TAG_NUM"
        const val TAG_PERSONAJE = "TAG_PERSONAJE"

        fun launch(context: Context, text: String,num: Int, personaje: Personaje) {
            val intent = Intent(context,SecondActivity::class.java)
            intent.putExtra(TAG_STRING, text)
            intent.putExtra(TAG_NUM,num)
            val gson = Gson()
            val personajeEnJson = gson.toJson(personaje)
            intent.putExtra(TAG_PERSONAJE, personajeEnJson)


            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra(TAG_STRING)
        val personajeEnJson = intent.getStringExtra(TAG_PERSONAJE)
        val personaje = personajeEnJson?.let{
            val gson = Gson()
            gson.fromJson(it,Personaje::class.java)
        }

        val num = intent.getIntExtra(TAG_NUM,0)

        personaje?.let {
            binding.tvContentReceived.text = text + num + it.nombre + it.age
        } ?:run {
            binding.tvContentReceived.text = text + num + 8
        }



    }
}