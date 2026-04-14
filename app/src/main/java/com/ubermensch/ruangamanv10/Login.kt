package com.ubermensch.ruangamanv10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels

class LoginActivity : AppCompatActivity() {
    // Jika nama file XML-nya fragment_login.xml, maka Binding-nya adalah FragmentLoginBinding
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.login(email, password)
            } else {
                Toast.makeText(this, "Isi email dan password", Toast.LENGTH_SHORT).show()
            }
        }

        // SESUAIKAN ID: dari tvDaftar menjadi btnKeDaftar
        binding.btnKeDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

            // SESUAIKAN ID: dari tvDaftar menjadi btnKeDaftar
            binding.btnKeDaftar.setOnClickListener {
                startActivity(Intent(this, RegisterActivity::class.java))
            }

        viewModel.loginResult.observe(this) { result ->
            when (result) {
                is Result.Success -> startActivity(
                    Intent(this, FormPendataanActivity::class.java)
                )
                is Result.Error -> Toast.makeText(
                    this, result.message, Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}