package com.example.jpls1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shopNowButton = findViewById<Button>(R.id.button2)

        shopNowButton.setOnClickListener {

            shopNowButton.visibility = View.GONE
            // Create an instance of your HomepageFragment
            val homePageFragment = Homepage()

            // Begin the fragment transaction
            val transaction = supportFragmentManager.beginTransaction()

            // Replace the fragment_container with the new fragment
            transaction.replace(R.id.fragment_container, homePageFragment)

            // Add the transaction to the back stack (optional)
            transaction.addToBackStack(null)

            // Commit the transaction
            transaction.commit()
        }
    }
}


