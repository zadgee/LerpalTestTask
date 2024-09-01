package domain.usecases
import domain.mapper.toEnteredDataDTO
import domain.models.EnteredUserDataDTO
import domain.repo.UserDataRepository

class GetDataByIdUseCase(
    private val repository: UserDataRepository
) {

    suspend fun execute(id:Int):EnteredUserDataDTO {
        return repository.getDataById(id).toEnteredDataDTO()
    }

}