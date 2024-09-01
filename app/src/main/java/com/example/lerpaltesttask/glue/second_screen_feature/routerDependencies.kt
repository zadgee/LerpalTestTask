package com.example.lerpaltesttask.glue.second_screen_feature
import domain.router.SecondScreenRouter
import domain.usecases.GetAllDataUseCase

fun provideSecondScreenRouter(
    getAllDataUseCase: GetAllDataUseCase,
): SecondScreenRouter {
    return SecondScreenRouterImpl(
        getAllDataUseCase = getAllDataUseCase,
    )
}