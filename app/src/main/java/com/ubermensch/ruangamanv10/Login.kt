package com.ubermensch.ruangamanv10

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ubermensch.ruangamanv10.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pindah ke Register via XML Action
        binding.btnKeDaftar.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_nav_login_to_nav_register)
        )

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            // Logika validasi simpel
            if (email.isNotBlank()) {
                // Simpan nama (diambil dari email sebelum @ sebagai simulasi) ke lokal
                val userName = email.substringBefore("@")
                saveUserName(userName)

                findNavController().navigate(R.id.action_nav_login_to_nav_home)
            } else {
                binding.etEmail.error = "Email tidak boleh kosong"
            }
        }
    }

    private fun saveUserName(name: String) {
        val sharedPref = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("user_name", name)
            apply()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
