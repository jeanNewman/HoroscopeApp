package com.jeandarwinnewmanrios.horoscapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel(
    @StringRes val text: Int,
    @DrawableRes val image: Int
)
