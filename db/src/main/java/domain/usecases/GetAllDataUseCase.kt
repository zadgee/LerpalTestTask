package domain.usecases
import androidx.paging.PagingData
import androidx.paging.map
import domain.mapper.toEnteredDataDTO
import domain.models.EnteredUserDataDTO
import domain.repo.UserDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllDataUseCase(
    private val repository: UserDataRepository
) {

    fun execute(): Flow<PagingData<EnteredUserDataDTO>>  {
        return repository.getAllUserData().map { pagingData->
            pagingData.map {
                it.toEnteredDataDTO()
            }
        }
    }

}