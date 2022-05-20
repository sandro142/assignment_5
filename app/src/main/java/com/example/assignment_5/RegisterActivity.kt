package com.example.assignment_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()

        RegisterListeners()
    }

    private fun init(){
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
    }

    private fun RegisterListeners(){

        buttonRegister.setOnClickListener{

            val email = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Fill in",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"you registered successfully",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}