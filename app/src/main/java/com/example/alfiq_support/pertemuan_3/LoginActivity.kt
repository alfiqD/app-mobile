package com.example.alfiq_support.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast // 1. Wajib import ini
import androidx.appcompat.app.AppCompatActivity
import com.example.alfiq_support.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // 2. Munculkan Pop-up (Toast)
            Toast.makeText(this, "Selamat, anda berhasil login!", Toast.LENGTH_SHORT).show()

            // 3. Pindah ke halaman Welcome setelah muncul pop-up
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)

            //finish() // Aktifkan jika ingin menutup halaman login
        }
    }
}