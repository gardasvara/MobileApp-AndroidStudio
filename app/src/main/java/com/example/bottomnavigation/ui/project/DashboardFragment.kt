package com.example.bottomnavigation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentDashboardBinding
import com.example.bottomnavigation.ui.project.DataUniv
import com.example.bottomnavigation.ui.project.ListUnivAdapter

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var rvunivs: RecyclerView
    private val list = ArrayList<DataUniv>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvunivs = binding.rvUnivs
        rvunivs.setHasFixedSize(true)
        list.addAll(getListunivs())
        showRecyclerList()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getListunivs(): ArrayList<DataUniv> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataImg = resources.obtainTypedArray(R.array.data_img)
        val dataWeb = resources.getStringArray(R.array.data_web)
        val dataWiki = resources.getStringArray(R.array.data_wiki)
        val dataMaps = resources.getStringArray(R.array.data_maps)
        val listHero = ArrayList<DataUniv>()
        for (i in dataName.indices) {
            val hero = DataUniv(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1), dataWeb[i], dataWiki[i], dataMaps[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvunivs.layoutManager = LinearLayoutManager(requireContext())
        val listUnivAdapter = ListUnivAdapter(list)
        rvunivs.adapter = listUnivAdapter

        listUnivAdapter.setOnItemClickCallback(object : ListUnivAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataUniv) {
                showSelectedUniv(data)
            }
        })
    }

    private fun showSelectedUniv(univ: DataUniv) {
        val bundle = bundleOf("selected_univ" to univ)
        findNavController().navigate(
            R.id.action_dashboardFragment_to_detailUniversityFragment,
            bundle
        )
    }
}
