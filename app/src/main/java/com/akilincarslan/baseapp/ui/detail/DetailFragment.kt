package com.akilincarslan.baseapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentDetailBinding
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseInjectionFragment<FragmentDetailBinding,DetailViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_detail
    override fun getViewModelClass(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}