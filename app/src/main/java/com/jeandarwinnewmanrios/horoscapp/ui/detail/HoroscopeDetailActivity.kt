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
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeModel
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
        horoscopeDetailViewModel.getHoroscope(args.type)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
          //  onBackPressed()
            // onBackPressed esta en desuso, que puedo usar?
            finish()
        }
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

    }

    private fun successState(it: HoroscopeDetailState.Success) {
        binding.pbDetail.isVisible = false
        binding.tvDetail.text = it.sign
        binding.tvBody.text = it.prediction
        val image: Int = when(it.horoscope){
            HoroscopeModel.Aries -> R.drawable.detail_aries
            HoroscopeModel.Taurus -> R.drawable.detail_taurus
            HoroscopeModel.Gemini -> R.drawable.detail_gemini
            HoroscopeModel.Cancer -> R.drawable.detail_cancer
            HoroscopeModel.Leo -> R.drawable.detail_leo
            HoroscopeModel.Virgo -> R.drawable.detail_virgo
            HoroscopeModel.Libra -> R.drawable.detail_libra
            HoroscopeModel.Scorpio -> R.drawable.detail_scorpio
            HoroscopeModel.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopeModel.Capricorn -> R.drawable.detail_capricorn
            HoroscopeModel.Aquarius -> R.drawable.detail_aquarius
            HoroscopeModel.Pisces -> R.drawable.detail_pisces

        }
        binding.ivDetail.setImageResource(image)
    }
}