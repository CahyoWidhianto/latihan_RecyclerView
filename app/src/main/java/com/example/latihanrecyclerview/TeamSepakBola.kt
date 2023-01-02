package com.example.latihanrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TeamSepakBola(
    var nama : String,
    var deskripsi : String,
    var logo : Int
) : Parcelable
