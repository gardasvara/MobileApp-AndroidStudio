package com.example.bottomnavigation.ui.project

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataUniv(
    val data_name: String,
    val data_desc: String,
    val data_img: Int,
    val data_web: String,
    val data_wiki: String,
    val data_maps: String
): Parcelable


