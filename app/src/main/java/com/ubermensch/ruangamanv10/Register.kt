package com.ubermensch.ruangamanv10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnDaftar.setOnClickListener { prosesDaftar() }

        binding.tvKeLogin.setOnClickListener { finish() }
    }

    private fun prosesDaftar() {
        val nama      = binding.etNama.text.toString().trim()
        val nik       = binding.etNik.text.toString().trim()
        val email     = binding.etEmailRegister.text.toString().trim()
        val noHp      = binding.etNoHp.text.toString().trim()
        val password  = binding.etPasswordRegister.text.toString()
        val konfirmasi = binding.etKonfirmasiPassword.text.toString()

        // Reset semua error
        binding.tilNama.error              = null
        binding.tilNik.error               = null
        binding.tilEmailRegister.error     = null
        binding.tilNoHp.error              = null
        binding.tilPasswordRegister.error  = null
        binding.tilKonfirmasiPassword.error = null

        // Validasi satu per satu
        if (nama.isEmpty()) {
            binding.tilNama.error = "Nama tidak boleh kosong"; return
        }
        if (nik.length != 16) {
            binding.tilNik.error = "NIK harus 16 digit"; return
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmailRegister.error = "Format email tidak valid"; return
        }
        if (noHp.length < 9) {
            binding.tilNoHp.error = "Nomor HP tidak valid"; return
        }
        if (password.length < 8) {
            binding.tilPasswordRegister.error = "Kata sandi minimal 8 karakter"; return
        }
        if (password != konfirmasi) {
            binding.tilKonfirmasiPassword.error = "Kata sandi tidak cocok"; return
        }
        if (!binding.cbSyarat.isChecked) {
            Toast.makeText(this, "Harap setujui syarat dan ketentuan", Toast.LENGTH_SHORT).show()
            return
        }

        // Simpan sementara di SharedPreferences
        val prefs = getSharedPreferences("ruangaman_users", MODE_PRIVATE)
        prefs.edit()
            .putString("user_email_$email", password)
            .putString("user_nama_$email",  nama)
            .apply()

        Toast.makeText(this, "Registrasi berhasil! Silakan login.", Toast.LENGTH_LONG).show()
        finish() // Kembali ke halaman login
    }
}