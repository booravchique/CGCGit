package com.example.careerguidancecenter.android.di

import com.example.careerguidancecenter.android.domain.models.getMyAnswers.GetMyAnswers
import com.example.careerguidancecenter.android.domain.repository.*
import com.example.careerguidancecenter.android.domain.usecases.*
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

    @Provides
    fun provideGetMyAnswer(repository: GetMyAnswersRepository): GetMyAnswersUseCase{
        return GetMyAnswersUseCase(repository)
    }

    @Provides
    fun provideSelectSkills(repository:SelectSkillsRepository): SelectSkillsUseCase{
        return SelectSkillsUseCase(repository)
    }

    @Provides
    fun provideMySelectSkills(repository: GetMySkillsRepository): GetMySelectSkillsUseCase{
        return GetMySelectSkillsUseCase(repository)
    }

    @Provides
    fun provideAllSelectSkills(repository: GetAllSkillsRepository): GetAllSkillsUseCase{
        return GetAllSkillsUseCase(repository)
    }

    @Provides
    fun provideChangePassword(repository: ChangePasswordRepository):ChangePasswordUseCase{
        return ChangePasswordUseCase(repository)
    }

    @Provides
    fun provideGetProfession(repository:GetProfessionRepository):GetProfessionUseCase{
        return GetProfessionUseCase(repository)
    }
}