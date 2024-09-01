package com.example.lerpaltesttask.glue.second_screen_feature
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.PagingData
import androidx.paging.map
import domain.models.RetrievedUserData
import domain.router.SecondScreenRouter
import domain.usecases.GetAllDataUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SecondScreenRouterImpl(
    private val getAllDataUseCase: GetAllDataUseCase,
): SecondScreenRouter {
    override fun getRetrievedUserData(): Flow<PagingData<RetrievedUserData>> {
        return getAllDataUseCase.execute().map { pagingData->
            pagingData.map {
                it.toEnteredUserDataDTO()
            }
        }
    }
}