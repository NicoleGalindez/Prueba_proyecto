package com.example.pruebaapp

import ManagerDb
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.pruebaapp.databinding.ActivityRegistroMenorBinding


class RegistroMenorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroMenorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroMenorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner = binding.tipoDocumentoMen

        // Datos de ejemplo para el Spinner
        val items = arrayOf("Registro Civil", "Tarjeta de identidad")

        // Crear un adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        // Establecer el diseño del adaptador para el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner
        spinner.adapter = adapter

        binding.confirmarRegistroMenButton.setOnClickListener{
            val nombreMen = binding.nombreMenInput.text.toString()
            val apellidoMen = binding.apellidoMenInput.text.toString()
            val tipoDocMen = spinner.selectedItem.toString()
            val numeroDocMen = binding.numeroDocumentoMenInput.text.toString()
            val telefonoMen = binding.telefonoMenInput.text.toString()
            val correoMen = binding.correoMenInput.text.toString()

            val manager = ManagerDb(this)
            manager.insertData(nombreMen, apellidoMen, tipoDocMen, numeroDocMen.toInt(), telefonoMen.toInt(), correoMen)

            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }
    }
}
