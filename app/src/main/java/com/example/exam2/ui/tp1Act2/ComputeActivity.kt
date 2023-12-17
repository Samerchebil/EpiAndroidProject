package com.example.exam2.ui.tp1Act2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.example.exam2.R

class ComputeActivity : AppCompatActivity() {

    lateinit var radioG : RadioGroup
    lateinit var sum : RadioButton
    lateinit var square : RadioButton
    lateinit var value1 : TextView
    lateinit var value2 : TextView
    lateinit var txtresultat : TextView
    lateinit var calculate : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compute)
        //  var sum : RadioButton = findViewById( R.id.sum)

        sum = findViewById( R.id.sum )
        square = findViewById( R.id.square )
        value1 = findViewById( R.id.value1 )
        value2 = findViewById( R.id.value2 )
        txtresultat = findViewById( R.id.txtresultat )
        calculate = findViewById( R.id.calculate )
        var valueButton : String
        var res: Int = 0
        calculate.setOnClickListener {

            val selectedOption: Int = radioG!!.checkedRadioButtonId
            val selectedRadioButton: RadioButton = findViewById(selectedOption)
            valueButton = selectedRadioButton.text.toString()
            val num1: String = value1.text.toString() ;
            val num2: String = value2.text.toString() ;
            val n1: Int = num1.toInt()
            val n2: Int = num2.toInt()

            if (  value1.text.isNotEmpty() &&  value2.text.isNotEmpty()  ) {
                if ( valueButton == "sum" ) {
                    res = n2 + n1 ;
                } else if ( valueButton == "square" ) {
                    res = n2 * n1 ;
                }
                valueButton = res.toString() ;
                txtresultat.setText( valueButton )

            }
            else {
                Toast.makeText(this , " veuillez remplir les champs " , Toast.LENGTH_LONG).show()
            }


        }

    }



}