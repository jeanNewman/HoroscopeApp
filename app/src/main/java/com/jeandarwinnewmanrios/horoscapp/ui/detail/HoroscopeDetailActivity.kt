package com.jeandarwinnewmanrios.horoscapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.jeandarwinnewmanrios.horoscapp.R
import com.jeandarwinnewmanrios.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.jeandarwinnewmanrios.horoscapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.activity_horoscope_detail)
        horoscopeDetailViewModel.getHoroscope(args.type.name)
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
       lifecycleScope.launch {
           repeatOnLifecycle(Lifecycle.State.STARTED){
               horoscopeDetailViewModel.state.collect{
                   when(it){
                         is HoroscopeDetailState.Loading -> loadingState()
                         is HoroscopeDetailState.Error -> errorState(it.error)
                         is HoroscopeDetailState.Success -> successState(it)
                   }
               }
           }
       }
    }

    private fun loadingState() {
       binding.pbDetail.isVisible = true
    }

    private fun errorState(error: String) {
        binding.pbDetail.isVisible = false
        Log.i("trucutru", "Error: $error")
    }

    private fun successState(it: HoroscopeDetailState.Success) {
        binding.pbDetail.isVisible = false
        binding.tvDetail.text = it.sign
        binding.tvBody.text = it.prediction
        Log.i("trucutru", "Success: ${it.sign} ${it.prediction}")
    }
}