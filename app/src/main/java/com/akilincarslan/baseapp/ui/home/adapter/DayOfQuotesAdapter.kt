package com.akilincarslan.baseapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akilincarslan.baseapp.databinding.ItemDayOfQuoteBinding
import com.akilincarslan.baseapp.databinding.ItemTopQuoteBinding
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.utils.Utils
import com.akilincarslan.baseapp.utils.extension.loadImage
import com.bumptech.glide.util.Util

class DayOfQuotesAdapter : RecyclerView.Adapter<DayOfQuotesAdapter.ViewHolder>() {

    var dayOfQuotesList = listOf<Quote>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDayOfQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dayOfQuotesList[position])
    }

    override fun getItemCount(): Int = dayOfQuotesList.size

    inner class ViewHolder(private val binding: ItemDayOfQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Quote) {
            binding.ivPhilosophy.loadImage(item.imageUrl)
            binding.tvQuote.text = item.quote.random()
            binding.tvPhilosopher.text = item.name
            binding.tvDay.text = Utils.getDayAsString(adapterPosition)
        }
    }
}