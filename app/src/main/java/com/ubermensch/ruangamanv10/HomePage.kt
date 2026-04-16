package com.ubermensch.ruangamanv10

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ubermensch.ruangamanv10.databinding.FragmentHomePageBinding
import androidx.navigation.Navigation

class HomePage : Fragment() {
    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load nama dari SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val savedName = sharedPref.getString("user_name", "User")
        binding.tvUserName.text = savedName

        // Hubungkan tombol ke Action di nav.xml
        binding.cardLaporBully.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_nav_report))
        binding.tvSeeAll.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_home_to_nav_education))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}