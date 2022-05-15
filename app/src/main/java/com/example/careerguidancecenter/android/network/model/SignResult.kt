package com.example.careerguidancecenter.android.network.model

import com.google.gson.annotations.SerializedName

data class SignResult(
    @SerializedName("token") var Token: String,
)