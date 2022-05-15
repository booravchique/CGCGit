package com.example.careerguidancecenter.android.di

import com.example.careerguidancecenter.android.domain.repository.SignUpRepository
import com.example.careerguidancecenter.android.domain.usecases.SIgnUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetSearchClientUseCase(repository: SignUpRepository):SIgnUpUseCase{
        return SIgnUpUseCase(repository)
    }
}