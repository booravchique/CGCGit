package com.example.careerguidancecenter.android.di

import com.example.careerguidancecenter.android.domain.repository.AnswerRepository
import com.example.careerguidancecenter.android.domain.repository.QuestionsRepository
import com.example.careerguidancecenter.android.domain.repository.SignInRepository
import com.example.careerguidancecenter.android.domain.repository.SignUpRepository
import com.example.careerguidancecenter.android.domain.usecases.AnswerUseCase
import com.example.careerguidancecenter.android.domain.usecases.QuestionsUseCase
import com.example.careerguidancecenter.android.domain.usecases.SIgnInUseCase
import com.example.careerguidancecenter.android.domain.usecases.SIgnUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideSignUpUseCase(repository: SignUpRepository):SIgnUpUseCase{
        return SIgnUpUseCase(repository)
    }

    @Provides
    fun provideSignInUseCase(repository: SignInRepository):SIgnInUseCase{
        return SIgnInUseCase(repository)
    }

    @Provides
    fun provideGetQuestions(repository: QuestionsRepository): QuestionsUseCase{
        return QuestionsUseCase(repository)
    }

    @Provides
    fun providePostAnswer(repository: AnswerRepository): AnswerUseCase{
        return  AnswerUseCase(repository)
    }
}