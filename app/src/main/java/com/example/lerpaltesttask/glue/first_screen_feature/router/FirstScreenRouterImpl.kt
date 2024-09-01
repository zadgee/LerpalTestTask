package com.example.lerpaltesttask.glue.first_screen_feature.router
import com.example.lerpaltesttask.glue.first_screen_feature.mapper.toEnteredDataDTO
import com.example.lerpaltesttask.glue.first_screen_feature.mapper.toEnteredUserDataMock
import domain.models.EnteredUserDataMock
import domain.router.FirstScreenRouter
import domain.usecases.GetDataByIdUseCase
import domain.usecases.InsertUserDataUseCase
import domain.usecases.UpdateUserDataUseCase

class FirstScreenRouterImpl(
    private val insertUserDataUseCase: InsertUserDataUseCase,
    private val updateUserDataUseCase: UpdateUserDataUseCase,
    private val getDataByIdUseCase: GetDataByIdUseCase
):FirstScreenRouter {
    override suspend fun insertUserData(data: EnteredUserDataMock) {
        insertUserDataUseCase.execute(data.toEnteredDataDTO())
    }

    override suspend fun updateUserData(data: EnteredUserDataMock) {
        updateUserDataUseCase.execute(data.toEnteredDataDTO())
    }

    override suspend fun getDataById(id: Int): EnteredUserDataMock {
        return getDataByIdUseCase.execute(id).toEnteredUserDataMock()
    }
}