package com.akilincarslan.baseapp.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akilincarslan.baseapp.databinding.ItemOnboardBinding
import com.akilincarslan.baseapp.models.Onboard

class OnboardingAdapter :RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    var onboardList = listOf<Onboard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ItemOnboardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OnboardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(onboardList[position])
    }

    override fun getItemCount(): Int = onboardList.size

    inner class OnboardingViewHolder(private val binding:ItemOnboardBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(onboard: Onboard) = with(binding) {
            textViewOnboard.text = onboard.title
            textViewOnboardDescription.text = onboard.description
            imageViewOnboard.setImageResource(onboard.imageDrawableRes)
        }
    }
}