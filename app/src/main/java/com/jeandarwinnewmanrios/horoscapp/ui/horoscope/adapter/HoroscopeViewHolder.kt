package com.jeandarwinnewmanrios.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.jeandarwinnewmanrios.horoscapp.databinding.ItemHoroscopeBinding
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo
import kotlin.random.Random

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscope: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) { // recibe la misma funcion lambda que se le pasa al adapter
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscope.img)
        binding.tvTitle.text = context.getString(horoscope.name)

        binding.clHoroscope.setOnClickListener {
            val typeRotation = Random.nextInt(0,3)
            startRotationAnimation(binding.ivHoroscope, typeRotation,newLambda = {
                onItemSelected(horoscope) //cuando se hace click en el item se ejecuta la funcion lambda horscope es el parametro que se le pasa a la funcion lambda item selecionado

            })

        }
    }

    fun startRotationAnimation(view: View,type: Int, newLambda: () -> Unit){
        view.animate().apply{
            duration = 500
            interpolator = LinearInterpolator()//interpolador que se encarga de hacer la animacion mas suave

            when(type) {
                0 -> rotationXBy(360f) //rota la vista 360 grados en el eje x
                1 -> rotationYBy(360f) //rota la vista 360 grados en el eje y
                2 -> rotationBy(360f) //rota la vista 360 grados
            }

            withEndAction{ newLambda()}
            start()
        }
    }

}