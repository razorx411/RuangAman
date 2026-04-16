package com.ubermensch.ruangamanv10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ubermensch.ruangamanv10.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kembali ke Login via XML Action (ID disesuaikan dengan fragment_register.xml)
        binding.tvKeLogin.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_nav_register_to_nav_login)
        )
        
        binding.btnBack.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_nav_register_to_nav_login)
        )

        binding.btnDaftar.setOnClickListener {
            // Logika pendaftaran simpel
            if (binding.etEmailRegister.text?.isNotBlank() == true) {
                // Setelah daftar, arahkan kembali ke Login
                findNavController().navigate(R.id.action_nav_register_to_nav_login)
            } else {
                binding.etEmailRegister.error = "Email tidak boleh kosong"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
