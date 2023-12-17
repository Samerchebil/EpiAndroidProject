package com.example.exam2.ui.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.exam2.R
import com.example.exam2.databinding.ActivityCalculBinding

class CalculActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultTextView: TextView = binding.textViewResult

        binding.btnAdd.setOnClickListener { performOperation(it) }
        binding.btnSubtract.setOnClickListener { performOperation(it) }
        binding.btnMultiply.setOnClickListener { performOperation(it) }
        binding.btnDivide.setOnClickListener { performOperation(it) }
    }

    private fun performOperation(view: View) {
        val number1: Int = binding.editTextNumber1.text.toString().toInt()
        val number2: Int = binding.editTextNumber2.text.toString().toInt()
        val resultTextView: TextView = binding.textViewResult

        val result: Int = when (view.id) {
            R.id.btnAdd -> number1 + number2
            R.id.btnSubtract -> number1 - number2
            R.id.btnMultiply -> number1 * number2
            R.id.btnDivide -> {
                if (number2 != 0) {
                    number1 / number2
                } else {
                    // Handle division by zero case
                    0
                }
            }
            else -> 0
        }

        resultTextView.text = "Résultat : $result"
    }
}