package com.example.jpls1

import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val validEmail = "paul@gmail.com"
    private val validPassword = "12345678"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myLogo = findViewById<ImageView>(R.id.logoImageView)
        val myMessage = findViewById<TextView>(R.id.textMessage)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val usernameEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)

        loginButton.setOnClickListener {
            val enteredEmail = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (enteredEmail == validEmail && enteredPassword == validPassword) {

                myMessage.visibility = View.GONE
                myLogo.visibility = View.GONE
                usernameEditText.visibility = View.GONE
                passwordEditText.visibility = View.GONE
                loginButton.visibility = View.GONE
                // If the login is successful, proceed to the homepage
                val homePageFragment = Homepage()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, homePageFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            } else {
                // If the login fails, show a toast message
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
