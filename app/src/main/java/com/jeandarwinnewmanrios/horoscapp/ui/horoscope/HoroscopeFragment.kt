package com.jeandarwinnewmanrios.horoscapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeandarwinnewmanrios.horoscapp.databinding.FragmentHoroscopeBinding
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo.*
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeModel
import com.jeandarwinnewmanrios.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null //que siginifica _binding y binding en este caso?  //binding es una propiedad privada que devuelve el valor de _binding y _binding es una variable privada que es nula
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initList()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter( onItemSelected = {
           val type :HoroscopeModel = when(it){

                Aries -> HoroscopeModel.Aries
                Taurus -> HoroscopeModel.Taurus
                Gemini -> HoroscopeModel.Gemini
                Cancer -> HoroscopeModel.Cancer
                Leo -> HoroscopeModel.Leo
                Virgo -> HoroscopeModel.Virgo
                Libra -> HoroscopeModel.Libra
                Scorpio -> HoroscopeModel.Scorpio
                Sagittarius -> HoroscopeModel.Sagittarius
                Capricorn -> HoroscopeModel.Capricorn
                Aquarius -> HoroscopeModel.Aquarius
                Pisces -> HoroscopeModel.Pisces

           }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = horoscopeAdapter
        }

    }

    private fun initUIState() {
        lifecycleScope.launch { //lifecycleScope es un scope que se encarga de manejar el ciclo de vida de un fragmento y launch es una funcion que se encarga de lanzar una corrutina, esta corrutina muere cuando el fragmento muere
            repeatOnLifecycle(Lifecycle.State.STARTED) { //repeatOnLifecycle es una funcion que se encarga de repetir una corrutina mientras el ciclo de vida del fragmento este en el estado que se le pase como parametro
                horoscopeViewModel.horoscope.collect {  //horoscopeViewModel.horoscope es una corrutina que se encarga de recolectar los datos de horoscope y collect es una funcion que se encarga de recolectar los datos de una corrutina
                   horoscopeAdapter.updateData(it) //adapter.submitList es una funcion que se encarga de enviar la lista de datos que se le pase como parametro al adapter
                }
            }
        }
    }

    override fun onCreateView(// cuando se crea la vista
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}