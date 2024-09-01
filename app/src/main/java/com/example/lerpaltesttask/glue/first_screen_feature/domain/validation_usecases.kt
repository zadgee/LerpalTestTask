package com.example.lerpaltesttask.glue.first_screen_feature.domain

import domain.usecases.ValidateDetailsUseCase
import domain.usecases.ValidateNameUseCase

fun provideValidateNameUseCase():ValidateNameUseCase{
    return ValidateNameUseCase()
}

fun provideValidateDetailsUseCase(): ValidateDetailsUseCase {
    return ValidateDetailsUseCase()
}