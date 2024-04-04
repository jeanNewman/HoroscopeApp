package com.jeandarwinnewmanrios.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeandarwinnewmanrios.horoscapp.R
import com.jeandarwinnewmanrios.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList() ,
    private val onItemSelected:(HoroscopeInfo) -> Unit) : //recibe una funcion lambda que recibe un HoroscopeInfo y no devuelve nada
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateData(newData: List<HoroscopeInfo>) {
        horoscopeList = newData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount() = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected) //le pasa la funcion lambda al viewholder
    }

}