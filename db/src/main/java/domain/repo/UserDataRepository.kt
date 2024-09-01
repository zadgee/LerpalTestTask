package domain.repo
import androidx.paging.PagingData
import data.entities.EnteredUserDataEntity
import domain.models.EnteredUserDataDTO
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    suspend fun insertUserData(data:EnteredUserDataDTO)
    fun getAllUserData():Flow<PagingData<EnteredUserDataEntity>>
    suspend fun updateUserData(dataDTO: EnteredUserDataDTO)
    suspend fun getDataById(id:Int):EnteredUserDataEntity
}