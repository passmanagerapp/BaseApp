package com.akilincarslan.baseapp.models

import com.akilincarslan.baseapp.utils.Utils

data class Quote(
    val name: String = "",
    val quote: List<String> = listOf(),
    val imageUrl: String = "",
    val birthDate: Int = 0,
    val deathDate: Int = 0,
    val isTop: Boolean = false,
    val period: Int = 0
) {
    val getDate: String
        get() {
            return if (birthDate > deathDate)
                "$deathDate-$birthDate DC"
            else
                "$birthDate-$deathDate"
        }

}
