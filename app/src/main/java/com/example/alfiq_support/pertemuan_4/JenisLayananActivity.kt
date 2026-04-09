package com.example.alfiq_support.pertemuan_4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alfiq_support.databinding.ActivityJenisLayananBinding

class JenisLayananActivity : AppCompatActivity() {

    // 1. Deklarasi View Binding
    private lateinit var binding: ActivityJenisLayananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inisialisasi View Binding
        binding = ActivityJenisLayananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ========================================================
        // 3. MENANGKAP DAN MENAMPILKAN DATA DARI INTENT
        // ========================================================
        val judulDiterima = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsiDiterima = intent.getStringExtra("EXTRA_DESKRIPSI")

        // Perhatikan ID yang dipanggil disesuaikan dengan XML Jenis Layanan
        if (judulDiterima != null) {
            binding.tvJudulBesar.text = judulDiterima
        }
        if (deskripsiDiterima != null) {
            binding.tvDeskripsi.text = deskripsiDiterima
        }

        // ========================================================
        // 4. FUNGSI KLIK TOMBOL BACK & PILIH LAYANAN
        // ========================================================
        binding.btnBack.setOnClickListener {
            finish() // Menutup halaman ini dan langsung kembali ke MainActivity
        }

        binding.btnPilihBpjs.setOnClickListener {
            Toast.makeText(this, "Anda telah memilih layanan BPJS", Toast.LENGTH_SHORT).show()
        }

        binding.btnPilihMandiri.setOnClickListener {
            Toast.makeText(this, "Anda telah memilih layanan Mandiri Pribadi", Toast.LENGTH_SHORT).show()
        }
    }
}