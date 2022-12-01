package com.akilincarslan.baseapp.ui.category

import android.os.Bundle
import android.view.View
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentCategoryBinding
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseInjectionFragment<FragmentCategoryBinding,CategoryViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_category

    override fun getViewModelClass(): Class<CategoryViewModel> = CategoryViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}