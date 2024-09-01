package com.example.lerpaltesttask.glue.first_screen_feature.router
import domain.router.FirstScreenRouter
import domain.usecases.GetDataByIdUseCase
import domain.usecases.InsertUserDataUseCase
import domain.usecases.UpdateUserDataUseCase


fun provideFirstScreenRouter(
    insertUserDataUseCase: InsertUserDataUseCase,
    updateUserDataUseCase: UpdateUserDataUseCase,
    getDataByIdUseCase: GetDataByIdUseCase
):FirstScreenRouter{
    return FirstScreenRouterImpl(
        insertUserDataUseCase = insertUserDataUseCase,
        updateUserDataUseCase = updateUserDataUseCase,
        getDataByIdUseCase = getDataByIdUseCase
    )
}