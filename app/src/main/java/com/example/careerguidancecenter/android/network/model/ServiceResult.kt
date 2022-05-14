package com.example.careerguidancecenter.android.network.model

data class ServiceResultGeneric<T>(
    var HttpStatusCode: Int,
    var Success: Boolean,
    var Errors: List<ServiceError>,
    var Value: T,
)

data class ServiceResult(
    var HttpStatusCode: Int,
    var Success: Boolean,
    var Errors: List<ServiceError>
)

data class ServiceError(
    var Name: String,
    var Description: String
)