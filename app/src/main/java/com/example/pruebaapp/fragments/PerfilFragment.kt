package com.example.pruebaapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import com.example.pruebaapp.R
import com.example.pruebaapp.RegistroMenorActivity
import com.example.pruebaapp.databinding.ActivityRegistroMenorBinding
import com.example.pruebaapp.databinding.FragmentPerfilBinding




class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegisMen.setOnClickListener {
            val intent = Intent(requireContext(), RegistroMenorActivity::class.java)
            startActivity(intent)
        }
    }
}
