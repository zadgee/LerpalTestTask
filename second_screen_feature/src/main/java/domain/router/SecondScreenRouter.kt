package domain.router

import androidx.paging.PagingData
import domain.models.RetrievedUserData
import kotlinx.coroutines.flow.Flow

interface SecondScreenRouter {
    fun getRetrievedUserData(): Flow<PagingData<RetrievedUserData>>
}