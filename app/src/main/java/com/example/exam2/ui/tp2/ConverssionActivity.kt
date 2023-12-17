package com.example.exam2.ui.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam2.R
import com.example.exam2.databinding.ActivityConverssionBinding


class ConverssionActivity : AppCompatActivity() {
    lateinit var binding:  ActivityConverssionBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConverssionBinding.inflate(layoutInflater);
        val valu= intent.getStringExtra("montant")
        val type= intent.getStringExtra("type")
        if (type=="dinar to euro"){
            if (valu != null) {
                binding.resultText.text =(valu.toInt()*3).toString()
            };
        }

        setContentView(binding.root)

    }
}