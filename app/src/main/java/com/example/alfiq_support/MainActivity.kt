package com.example.alfiq_support

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.example.alfiq_support.databinding.ActivityMainBinding
import com.example.alfiq_support.pertemuan_2.BangunRuangActivity
import com.example.alfiq_support.pertemuan_3.LoginActivity
import com.example.alfiq_support.pertemuan_4.JenisLayananActivity
import com.example.alfiq_support.pertemuan_4.ProfilActivity

class MainActivity : AppCompatActivity() {

    // 1. Deklarasi View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ========================================================
        // TOMBOL 1: Pindah ke Halaman Rumus
        // ========================================================
        binding.btnRumus.setOnClickListener {
            // Sudah disesuaikan dengan nama activity Anda: BangunRuangActivity
            val intent = Intent(this, BangunRuangActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "Rumus Bangun Ruang")
            intent.putExtra("EXTRA_DESKRIPSI", "Halaman perhitungan matematika bangun ruang")
            startActivity(intent)
        }

        // ========================================================
        // TOMBOL 2: Pindah ke Custom 1 (Profil)
        // ========================================================
        binding.btnProfil.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "Profil Pengguna")
            intent.putExtra("EXTRA_DESKRIPSI", "Kelola informasi akun dan pengaturan aplikasi Anda di sini.")
            startActivity(intent)
        }

        // ========================================================
        // TOMBOL 3: Pindah ke Custom 2 (Jenis Layanan)
        // ========================================================
        binding.btnLayanan.setOnClickListener {
            val intent = Intent(this, JenisLayananActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "Pilihan Layanan")
            intent.putExtra("EXTRA_DESKRIPSI", "Apakah Anda pengguna BPJS atau layanan mandiri?")
            startActivity(intent)
        }

        // ========================================================
        // TOMBOL 4: Tombol Logout (AlertDialog & Snackbar)
        // ========================================================
        binding.btnLogout.setOnClickListener { view ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Logout")
            builder.setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")

            // Jika memilih YA (Berpindah ke halaman Login)
            builder.setPositiveButton("Ya") { dialog, _ ->
                // (Catatan: Pastikan Anda sudah membuat file LoginActivity)
                val intent = Intent(this, LoginActivity::class.java)
                // Membersihkan tumpukan halaman agar user tidak bisa tekan tombol back ke MainActivity
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }

            // Jika memilih TIDAK (Memunculkan Snackbar)
            builder.setNegativeButton("Tidak") { dialog, _ ->
                Snackbar.make(view, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            // Tampilkan dialognya ke layar
            builder.create().show()
        }
    }
}