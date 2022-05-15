package com.example.careerguidancecenter.android.network.model

import com.google.gson.annotations.SerializedName

data class ServiceResultGeneric<T>(
    @SerializedName("httpStatusCode") var HttpStatusCode: Int,
    @SerializedName("success") var Success: Boolean,
    @SerializedName("errors") var Errors: List<ServiceError>,
    @SerializedName("value") var Value: T,
)

data class ServiceResult(
    @SerializedName("httpStatusCode") var HttpStatusCode: Int,
    @SerializedName("success") var Success: Boolean,
    @SerializedName("errors") var Errors: List<ServiceError>
)

data class ServiceError(
    @SerializedName("name") var Name: String,
    @SerializedName("description") var Description: String
)