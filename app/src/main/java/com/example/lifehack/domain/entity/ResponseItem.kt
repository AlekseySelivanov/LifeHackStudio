package com.example.lifehack.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseItem(
    @SerializedName("id")
    @Expose
    val id: String? = null,
    @SerializedName("img")
    @Expose
    val img: String,
    @SerializedName("name")
    @Expose
    val name: String? = null
): Parcelable