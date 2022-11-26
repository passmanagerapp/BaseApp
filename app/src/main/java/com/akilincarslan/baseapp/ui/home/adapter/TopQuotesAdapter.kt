package com.akilincarslan.baseapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akilincarslan.baseapp.databinding.ItemTopQuoteBinding
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.utils.extension.loadImage

class TopQuotesAdapter : RecyclerView.Adapter<TopQuotesAdapter.ViewHolder>() {

    var topQuoteList = listOf<Quote>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemTopQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(topQuoteList[position])
    }

    override fun getItemCount(): Int = topQuoteList.size

    inner class ViewHolder(private val binding: ItemTopQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Quote) {
            binding.ivPhilosophy.loadImage(item.imageUrl)
            binding.tvQuote.text = item.quote.random()
            binding.tvPhilosopher.text = item.name
        }
    }
}