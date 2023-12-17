package com.example.exam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth;
    lateinit var email: EditText;
    lateinit var password: EditText
    lateinit var btn: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth= FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        password=findViewById(R.id.password)
        btn=findViewById(R.id.login)
        btn.setOnClickListener { login() }
    }
    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser?=mAuth.currentUser
        if(currentUser!==null){
            Toast.makeText(this,"user already connected", Toast.LENGTH_LONG).show()
        }
    }
    fun login() {
        mAuth.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val currentUser: FirebaseUser? = mAuth.currentUser
                Toast.makeText(this, "Auth success", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Finish the LoginActivity to prevent going back to it when pressing the back button
                finish()

            } else {
                Toast.makeText(this, "Auth failed", Toast.LENGTH_LONG).show()
            }
        }
    }
}