package com.smartypants.smartvis

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class loginActivity() : AppCompatActivity(){

    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "loginpage", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.login)

        val btnLoginAccount: Button? = findViewById(R.id.loginButton)
        val btnRegisterAccount: Button? = findViewById(R.id.btnRegisterAccount)

        btnLoginAccount!!.setOnClickListener(View.OnClickListener {
            view -> login()
        })
        btnRegisterAccount!!.setOnClickListener{

            val intent = Intent(this,registerActivity::class.java)
            startActivity(intent)
        }


    }



    private fun login()
    {
        val vemail: EditText? = findViewById(R.id.emailId)
        val email = vemail?.text.toString()

        val vpassword : EditText? = findViewById(R.id.bar_graph)
        val password = vpassword?.text.toString()
        if (!email.isEmpty() && !password.isEmpty()) {
            this.mAuth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {

                    startActivity(Intent(this, MainActivity ::class.java))
                    Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                }
            })

        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }


}
