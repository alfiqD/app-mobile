package com.example.alfiq_support.pertemuan_2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alfiq_support.databinding.ActivityBangunRuangBinding

class BangunRuangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBangunRuangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBangunRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ========================================================
        // 1. TOMBOL KEMBALI (BACK)
        // ========================================================
        binding.btnBack.setOnClickListener {
            finish() // Menutup halaman ini dan kembali ke halaman sebelumnya
        }

        // ========================================================
        // 2. MENANGKAP DATA INTENT
        // ========================================================
        val judulDiterima = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsiDiterima = intent.getStringExtra("EXTRA_DESKRIPSI")

        // Karena TextView-nya sudah kita buat di XML, kita aktifkan kodenya:
        if (judulDiterima != null) {
            binding.tvJudulDariDepan.text = judulDiterima
        }
        if (deskripsiDiterima != null) {
            binding.tvDeskripsiDariDepan.text = deskripsiDiterima
        }

        // ========================================================
        // 3. LOGIKA PERHITUNGAN KALKULATOR
        // ========================================================

        // Tombol Segitiga
        binding.btnSegitiga.setOnClickListener {
            val alasStr = binding.etAlas.text.toString()
            val tinggiStr = binding.etTinggi.text.toString()

            if (alasStr.isNotEmpty() && tinggiStr.isNotEmpty()) {
                val alas = alasStr.toDouble()
                val tinggi = tinggiStr.toDouble()

                val luas = 0.5 * alas * tinggi
                binding.tvHasilSegitiga.text = "Hasil Luas = $luas"
                Log.d("SEGITIGA", "Perhitungan berhasil: $luas")
            } else {
                Toast.makeText(this, "Alas dan Tinggi harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }

        // Tombol Kubus
        binding.btnKubus.setOnClickListener {
            val sisiStr = binding.etSisi.text.toString()

            if (sisiStr.isNotEmpty()) {
                val sisi = sisiStr.toDouble()
                val volume = sisi * sisi * sisi

                binding.tvHasilKubus.text = "Hasil Volume = $volume"
                Log.d("KUBUS", "Perhitungan berhasil: $volume")
            } else {
                Toast.makeText(this, "Sisi harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}