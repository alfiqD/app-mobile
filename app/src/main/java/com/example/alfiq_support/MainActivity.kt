package com.example.alfiq_support

//package com.example.kalkulatorbangun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var etAlas: EditText
    lateinit var etTinggi: EditText
    lateinit var etSisi: EditText

    lateinit var btnSegitiga: Button
    lateinit var btnKubus: Button

    lateinit var tvHasilSegitiga: TextView
    lateinit var tvHasilKubus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAlas = findViewById(R.id.etAlas)
        etTinggi = findViewById(R.id.etTinggi)
        etSisi = findViewById(R.id.etSisi)

        btnSegitiga = findViewById(R.id.btnSegitiga)
        btnKubus = findViewById(R.id.btnKubus)

        tvHasilSegitiga = findViewById(R.id.tvHasilSegitiga)
        tvHasilKubus = findViewById(R.id.tvHasilKubus)

        btnSegitiga.setOnClickListener {

            val alas = etAlas.text.toString().toDouble()
            val tinggi = etTinggi.text.toString().toDouble()

            val luas = 0.5 * alas * tinggi

            tvHasilSegitiga.text = "Hasil Luas = $luas"

            Log.d("SEGITIGA", "Perhitungan berhasil")
        }

        btnKubus.setOnClickListener {

            val sisi = etSisi.text.toString().toDouble()

            val volume = sisi * sisi * sisi

            tvHasilKubus.text = "Hasil Volume = $volume"

            Log.d("KUBUS", "Perhitungan berhasil")
        }
    }
}