package com.subranil.covid19traker.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Details (
    val active: String = "0",
    val confirmed: String = "0",
    val recovered: String = "0",
    val deaths: String = "0",
    val state: String = "",

    @Json(name = "statenotes")
    val stateNotes: String = "",

    @Json(name = "deltaconfirmed")
    val deltaConfirmed: String = "0",

    @Json(name = "deltarecovered")
    val deltaRecovered: String = "0",

    @Json(name = "deltadeaths")
    val deltaDeaths: String = "0",

    @Json(name = "lastupdatedtime")
    val lastUpdatedTime: String = ""
): Parcelable