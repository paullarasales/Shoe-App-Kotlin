package com.example.jpls1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.jpls1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the "Shop Now" button
        val shopNowButton = findViewById<Button>(R.id.button2)

        // Set a click listener for the button
        shopNowButton.setOnClickListener {
            // Create an instance of your HomepageFragment
            val homePageFragment = Homepage()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, homePageFragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }
    }
}

