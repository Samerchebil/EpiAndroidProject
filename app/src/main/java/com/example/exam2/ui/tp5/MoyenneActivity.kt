package com.example.exam2.ui.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.exam2.R
import com.example.exam2.databinding.ActivityMoyenneBinding

class MoyenneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoyenneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoyenneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultTextView: TextView = binding.textViewResult

        binding.btnCalculateAverage.setOnClickListener { calculateAverage() }
    }

    private fun calculateAverage() {
        val grade1: Float = binding.editTextGrade1.text.toString().toFloatOrNull() ?: 0.0f
        val grade2: Float = binding.editTextGrade2.text.toString().toFloatOrNull() ?: 0.0f
        val grade3: Float = binding.editTextGrade3.text.toString().toFloatOrNull() ?: 0.0f
        val resultTextView: TextView = binding.textViewResult

        val average: Float = (grade1 + grade2 + grade3) / 3

        resultTextView.text = "Moyenne : $average"
    }
}