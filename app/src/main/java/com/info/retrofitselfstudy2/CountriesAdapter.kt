package com.info.retrofitselfstudy2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.countries_item.view.*

class CountriesAdapter(private val context:Context,private var list: MutableList<CountriesItem>):RecyclerView.Adapter<CountriesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.countries_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = list[position]

        holder.area.text = "Ölkə - ${country.name} "  + " | " + " Ərazisi - ${country.area} "
        holder.capital.text = "Paytaxti - ${country.capital} " + " | " + "Əhalisi - ${country.population}"
        holder.region.text = "Regionu -  ${country.region}" + " | " + "Coğrafi istiqaməti - ${country.subregion}"

        val currencies = country.currencies
        var currency = ""
//        if (currencies.isEmpty())
//            currency = currency.plus(currencies[0].code).plus(" ").plus(currencies[0].name).plus(" ").plus(currencies[0].symbol)
        holder.currencies.text = currency

        val flags = country.flags
        Glide.with(holder.action.context).load(flags.png).into(holder.action)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var area:TextView = view.txt_area
        var capital:TextView = view.txt_capital
        var currencies:TextView = view.txt_currencies
        var region:TextView = view.txt_region
        var action: ImageView = view.action_image
    }

}