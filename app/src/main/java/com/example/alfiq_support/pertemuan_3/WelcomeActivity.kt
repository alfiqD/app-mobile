package com.example.alfiq_support.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper // Wajib import ini untuk Timer
import androidx.appcompat.app.AppCompatActivity
import com.example.alfiq_support.MainActivity
import com.example.alfiq_support.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ========================================================
        // LOGIKA TIMER: Pindah otomatis setelah 2 detik
        // ========================================================

        // Angka 2000 di bawah berarti 2000 milidetik (2 detik)
        Handler(Looper.getMainLooper()).postDelayed({

            // Perintah pindah ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Tutup halaman welcome agar tidak bisa di-back
            finish()

        }, 2000) // Anda bisa mengganti angka 2000 ini jika ingin lebih lama (misal 3000 untuk 3 detik)
    }
}