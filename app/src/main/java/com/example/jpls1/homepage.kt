package com.example.jpls1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat


class Homepage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_homepage, container, false)

        // Initial selection (All Items)
        replaceFragment(AllItems())
        setSectionSelected(view.findViewById(R.id.textView5)) // Set the initial selection

        // Handle the category clicks
        val allTextView: TextView = view.findViewById(R.id.textView5)
        val basketballShoesTextView: TextView = view.findViewById(R.id.textView6)
        val socksTextView: TextView = view.findViewById(R.id.textView7)

        allTextView.setOnClickListener {
            // Display the AllFragment
            replaceFragment(AllItems())
            setSectionSelected(allTextView)
        }

        basketballShoesTextView.setOnClickListener {
            // Display the BasketballShoesFragment
            replaceFragment(BasketBallShoes())
            setSectionSelected(basketballShoesTextView)
        }

        socksTextView.setOnClickListener {
            // Display the SocksFragment
            replaceFragment(Socks())
            setSectionSelected(socksTextView)
        }

        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.homepage_fragment_container, fragment)
            ?.commit()
    }

    private fun setSectionSelected(textView: TextView) {
        // Reset color for all text views
        val allTextView: TextView = view?.findViewById(R.id.textView5) ?: return
        val basketballShoesTextView: TextView = view?.findViewById(R.id.textView6) ?: return
        val socksTextView: TextView = view?.findViewById(R.id.textView7) ?: return

        allTextView.setTextColor(getTextColor(allTextView, false))
        basketballShoesTextView.setTextColor(getTextColor(basketballShoesTextView, false))
        socksTextView.setTextColor(getTextColor(socksTextView, false))

        // Set the selected text color for the clicked text view
        textView.setTextColor(getTextColor(textView, true))
    }

    private fun getTextColor(textView: TextView, isSelected: Boolean): Int {
        // Define your color values here
        val activeColor = ContextCompat.getColor(requireContext(), R.color.defaultTextColor)
        val inactiveColor = ContextCompat.getColor(requireContext(), R.color.inactiveTextColor)

        // Return the appropriate color
        return if (isSelected) activeColor else inactiveColor
    }
}
