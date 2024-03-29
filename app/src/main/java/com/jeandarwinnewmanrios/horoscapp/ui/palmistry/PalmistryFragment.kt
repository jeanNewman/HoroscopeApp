package com.jeandarwinnewmanrios.horoscapp.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeandarwinnewmanrios.horoscapp.R
import com.jeandarwinnewmanrios.horoscapp.databinding.FragmentLuckBinding
import com.jeandarwinnewmanrios.horoscapp.databinding.FragmentPalmistryBinding

class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null //que siginifica _binding y binding en este caso?  //binding es una propiedad privada que devuelve el valor de _binding y _binding es una variable privada que es nula
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}