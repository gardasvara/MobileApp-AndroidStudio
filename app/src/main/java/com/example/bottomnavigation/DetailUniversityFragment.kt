package com.example.bottomnavigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigation.databinding.FragmentDetailUniversityBinding
import com.example.bottomnavigation.ui.project.DataUniv

class DetailUniversityFragment : Fragment() {
    private var _binding: FragmentDetailUniversityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailUniversityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Detail Universitas"
        val univ = arguments?.getParcelable<DataUniv>("selected_univ")

        if (univ != null) {
            binding.univ = univ

            binding.buttonWeb.setOnClickListener {
                openUrl(univ.data_web)
            }
            binding.buttonWiki.setOnClickListener {
                openUrl(univ.data_wiki)
            }
            binding.buttonMaps.setOnClickListener {
                openUrl(univ.data_maps)
            }
        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

