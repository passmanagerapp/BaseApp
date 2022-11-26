package com.akilincarslan.baseapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akilincarslan.baseapp.databinding.ItemDayOfQuoteBinding
import com.akilincarslan.baseapp.databinding.ItemPeriodicBinding
import com.akilincarslan.baseapp.databinding.ItemTopQuoteBinding
import com.akilincarslan.baseapp.enums.PeriodType
import com.akilincarslan.baseapp.enums.Status
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.utils.Utils
import com.akilincarslan.baseapp.utils.extension.loadImage
import com.bumptech.glide.util.Util

class PeriodicAdapter : RecyclerView.Adapter<PeriodicAdapter.ViewHolder>() {

    var periodList = listOf<Quote>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPeriodicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(periodList[position])
    }

    override fun getItemCount(): Int = periodList.size

    inner class ViewHolder(private val binding: ItemPeriodicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Quote) {
            binding.ivPhilosophy.loadImage(item.imageUrl)
            binding.tvMainQuote.text = item.quote.random()
            binding.tvPhilosopher.text = item.name
            binding.tvPeriod.text = PeriodType.values()[item.period].name.removePrefix("_")
            binding.tvDate.text = item.getDate
        }
    }
}