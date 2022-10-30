package com.akilincarslan.baseapp.utils

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.akilincarslan.baseapp.utils.helpers.LocalHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().enableOnBackPressed(true)
    }

    val localHelper: LocalHelper
        get() = LocalHelper(requireContext())

    fun navigate(resId: Int, args: Bundle? = null, navOptions: NavOptions? = null) {
        findNavController().navigate(resId, args, navOptions)
    }

    fun navigate(direction: NavDirections, navOptions: NavOptions? = null) {
        findNavController().navigate(direction, navOptions)
    }
}