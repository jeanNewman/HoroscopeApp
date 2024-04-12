package com.jeandarwinnewmanrios.horoscapp.ui.providers

import com.jeandarwinnewmanrios.horoscapp.R
import com.jeandarwinnewmanrios.horoscapp.ui.model.LuckyModel

import javax.inject.Inject
import kotlin.random.Random

class RandomCardProvider @Inject constructor() {
    fun getLucky(): LuckyModel {
        return when (Random.nextInt(0, 32)) {
            0 -> LuckyModel(R.string.luck_01, R.drawable.card_fool)
            1 -> LuckyModel(R.string.luck_02, R.drawable.card_magician)
            2 -> LuckyModel(R.string.luck_03, R.drawable.card_priestess)
            3 -> LuckyModel(R.string.luck_04, R.drawable.card_empress)
            4 -> LuckyModel(R.string.luck_05, R.drawable.card_sword)
            5 -> LuckyModel(R.string.luck_06, R.drawable.card_hierophant)
            6 -> LuckyModel(R.string.luck_07, R.drawable.card_lovers)
            7 -> LuckyModel(R.string.luck_08, R.drawable.card_chariot)
            8 -> LuckyModel(R.string.luck_09, R.drawable.card_strength)
            9 -> LuckyModel(R.string.luck_10, R.drawable.card_hermit)
            10 -> LuckyModel(R.string.luck_11, R.drawable.card_ace_pentacles)
            11 -> LuckyModel(R.string.luck_12, R.drawable.card_justice)
            12 -> LuckyModel(R.string.luck_13, R.drawable.card_judgement)
            13 -> LuckyModel(R.string.luck_14, R.drawable.card_death)
            14 -> LuckyModel(R.string.luck_15, R.drawable.card_temperance)
            15 -> LuckyModel(R.string.luck_16, R.drawable.card_devil)
            16 -> LuckyModel(R.string.luck_17, R.drawable.card_tower)
            17 -> LuckyModel(R.string.luck_18, R.drawable.card_star)
            18 -> LuckyModel(R.string.luck_19, R.drawable.card_moon)
            19 -> LuckyModel(R.string.luck_20, R.drawable.card_sun)
            20 -> LuckyModel(R.string.luck_21, R.drawable.card_judgement)
            21 -> LuckyModel(R.string.luck_22, R.drawable.card_world)
            22 -> LuckyModel(R.string.luck_23, R.drawable.card_wheel_fortune)
            23 -> LuckyModel(R.string.luck_24, R.drawable.card_queen_wands)
            24 -> LuckyModel(R.string.luck_25, R.drawable.card_queen_swords)
            25 -> LuckyModel(R.string.luck_26, R.drawable.card_nine_wands)
            26 -> LuckyModel(R.string.luck_27, R.drawable.card_page_wands)
            27 -> LuckyModel(R.string.luck_28, R.drawable.card_king_cups)
            28 -> LuckyModel(R.string.luck_29, R.drawable.card_king_pentacles)
            29 -> LuckyModel(R.string.luck_30, R.drawable.card_king_swords)
            30 -> LuckyModel(R.string.luck_31, R.drawable.card_king_pentacles)
            31 -> LuckyModel(R.string.luck_00, R.drawable.card_queen_pentacles)


            else -> {
                LuckyModel(R.string.luck_00, R.drawable.card_queen_pentacles)}
        }
    }
}