package domain.usecases
import domain.models.EnteredUserDataDTO
import domain.repo.UserDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateUserDataUseCase(
    private val repository: UserDataRepository
){

    suspend fun execute(
        data: EnteredUserDataDTO
    )= withContext(Dispatchers.IO){
        repository.updateUserData(data)
    }

}