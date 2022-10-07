package com.akilincarslan.baseapp.models

import androidx.annotation.DrawableRes

data class Onboard(
    @DrawableRes
    val imageDrawableRes:Int,
    val title: String = "",
    val description: String = ""
)
