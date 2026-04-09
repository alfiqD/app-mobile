package com.example.alfiq_support.pertemuan_4// Jangan ubah baris pertama ini, biarkan bawaan laptop Anda!

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alfiq_support.databinding.ActivityProfilBinding

class ProfilActivity : AppCompatActivity() {

    // 1. Deklarasi View Binding
    private lateinit var binding: ActivityProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inisialisasi View Binding
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ========================================================
        // 3. MENANGKAP DAN MENAMPILKAN DATA DARI INTENT
        // ========================================================
        val judulDiterima = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsiDiterima = intent.getStringExtra("EXTRA_DESKRIPSI")

        // Memasang teks ke TextView langsung menggunakan binding
        if (judulDiterima != null) {
            binding.tvJudulDariDepan.text = judulDiterima
        }
        if (deskripsiDiterima != null) {
            binding.tvDeskripsiDariDepan.text = deskripsiDiterima
        }

        // ========================================================
        // 4. FUNGSI KLIK TOMBOL EDIT & LOGOUT
        // ========================================================
        binding.btnEdit.setOnClickListener {
            // Memunculkan pesan kecil (Toast)
            Toast.makeText(this, "Fitur Edit Profil sedang dikembangkan", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            Toast.makeText(this, "Berhasil kembali ke Halaman Utama", Toast.LENGTH_SHORT).show()
            // Menutup halaman profil dan otomatis kembali ke MainActivity
            finish()
        }
    }
}