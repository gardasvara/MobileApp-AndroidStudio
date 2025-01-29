package com.example.bottomnavigation.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.bottomnavigation.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val btnShareProfile: Button = view.findViewById(R.id.share_button)
        btnShareProfile.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Bagikan profile saya")
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
        btnShareProfile.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_share, 0, 0, 0)
        btnShareProfile.compoundDrawablePadding = 8


        return view
    }
}
