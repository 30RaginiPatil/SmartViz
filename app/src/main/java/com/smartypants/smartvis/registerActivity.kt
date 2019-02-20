package com.smartypants.smartvis

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registerActivity : AppCompatActivity(){

    private val mAuth : FirebaseAuth? = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val registerButton:Button? = findViewById(R.id.registerButton)
        registerButton?.setOnClickListener(View.OnClickListener {
            view -> register()
        })
    }

    private fun register()
    {
        val emailtxt = findViewById<View>(R.id.emailId) as EditText
        val pwtxt = findViewById<View>(R.id.password) as EditText

        val email = emailtxt.text.toString()
        val password = pwtxt.text.toString()
        this.mAuth?.createUserWithEmailAndPassword(email, password)?.addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Toast.makeText(this, "Registered.", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity ::class.java))
            } else {
                Toast.makeText(this, "Couldn't Register..", Toast.LENGTH_LONG).show()

            }

            // ...
        }
    }
}