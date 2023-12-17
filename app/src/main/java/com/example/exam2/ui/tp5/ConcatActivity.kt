package com.example.exam2.ui.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exam2.R
import com.example.exam2.databinding.ActivityConcatBinding

class ConcatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConcatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConcatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultTextView = binding.textViewResult

        binding.btnConcat.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            val concatenatedText = if (binding.checkBox.isChecked) {
                "$text1$text2, Longueur: ${text1.length + text2.length}"
            } else {
                "$text1$text2"
            }

            // Afficher la chaîne concaténée dans le TextView
            resultTextView.text = concatenatedText

            // Afficher la chaîne concaténée (vous pouvez utiliser un Toast)
            Toast.makeText(this, concatenatedText, Toast.LENGTH_SHORT).show()
        }
    }
}