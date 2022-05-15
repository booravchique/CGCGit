package com.example.careerguidancecenter.android.di

import com.example.careerguidancecenter.android.data.network.ApiServ
import com.example.careerguidancecenter.android.data.network.NetworkApiStorage
import com.example.careerguidancecenter.android.data.network.NetworkStorage
import com.example.careerguidancecenter.android.data.repository.SignUpRepositoryImpl
import com.example.careerguidancecenter.android.domain.repository.SignUpRepository
import com.example.careerguidancecenter.android.network.ApiService
import com.example.careerguidancecenter.android.network.AuthorizationService
import com.google.gson.Gson
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {



    @Provides
    @Singleton
    fun provideGson(): Gson
    {
        return Gson()
    }

    @Provides
    @IoDispatcher
    @Singleton
    fun corutineDisp(): CoroutineDispatcher = Dispatchers.IO



    @Provides
    @Singleton
    fun provideNetworkStorage(retrofit: ApiServ, gson: Gson): NetworkStorage {
        return NetworkApiStorage(retrofit,gson)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        var httpClient : OkHttpClient
        val logi= HttpLoggingInterceptor()
        logi.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logi)
            .dns(Dns.SYSTEM)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): ApiServ {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(
                "https://fm.tringle.org/api/"
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
            .create(ApiServ::class.java)
    }

    @Provides
    @Singleton
    fun provideSignIn(networkStorage:NetworkStorage,gson: Gson,@IoDispatcher dispatcher: CoroutineDispatcher): SignUpRepository {
        return SignUpRepositoryImpl(networkStorage,gson,dispatcher)
    }


    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        return ApiService(okHttpClient, "https://fm.tringle.org/api")
    }

    @Provides
    @Singleton
    fun provideAuthorizationService(apiService: ApiService): AuthorizationService {
        return AuthorizationService(apiService)
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher