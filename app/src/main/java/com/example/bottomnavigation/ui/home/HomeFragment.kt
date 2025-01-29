package com.example.bottomnavigation.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView
    private lateinit var buttonGithub: ImageButton
    private lateinit var buttonInstagram: ImageButton
    private lateinit var buttonLinkedin: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        findViewById(root)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun findViewById(view: View) {
        text1 = view.findViewById(R.id.text1)
        text2 = view.findViewById(R.id.text2)
        text3 = view.findViewById(R.id.text3)

        buttonGithub = view.findViewById(R.id.imageButton2)
        buttonInstagram = view.findViewById(R.id.imageButton3)
        buttonLinkedin = view.findViewById(R.id.imageButton4)

        buttonGithub.setOnClickListener {
            openUrl("https://github.com/gardasvara")
        }
        buttonInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/gardasvara/")
        }
        buttonLinkedin.setOnClickListener {
            openUrl("https://www.linkedin.com/in/gardasvara-mistortoify-0896a3261/")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
