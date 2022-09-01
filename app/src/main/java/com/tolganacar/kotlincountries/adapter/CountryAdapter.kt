package com.tolganacar.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tolganacar.kotlincountries.R
import com.tolganacar.kotlincountries.databinding.RecyclerRowBinding
import com.tolganacar.kotlincountries.model.Country
import com.tolganacar.kotlincountries.util.downloadFromUrl
import com.tolganacar.kotlincountries.util.placeholderProgressBar
import com.tolganacar.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.recycler_row.view.*

class CountryAdapter(val countryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener {

    class CountryViewHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RecyclerRowBinding>(inflater, R.layout.recycler_row,parent,false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.country = countryList.get(position)
        holder.binding.listener = this
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList : List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = v.countryUuidText.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToDetailsFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}