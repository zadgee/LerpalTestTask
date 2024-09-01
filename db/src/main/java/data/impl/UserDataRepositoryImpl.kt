package data.impl
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import data.dao.EnteredUserDataDao
import data.entities.EnteredUserDataEntity
import domain.mapper.toEnteredDataDTO
import domain.mapper.toEnteredDataEntity
import domain.models.EnteredUserDataDTO
import domain.repo.UserDataRepository
import kotlinx.coroutines.flow.Flow

class UserDataRepositoryImpl(
    private val dao: EnteredUserDataDao
): UserDataRepository {
    override suspend fun insertUserData(data:EnteredUserDataDTO) {
        return try {
            dao.insertUserData(
                data.toEnteredDataEntity()
            )
        } catch (e:Exception){
           throw Exception(e.message)
        }
    }

    override fun getAllUserData(): Flow<PagingData<EnteredUserDataEntity>> {
      return Pager(
          config = PagingConfig(
              pageSize = 5,
              enablePlaceholders = false
          ),
          pagingSourceFactory = { dao.dataPagingSource() }
      ).flow
    }

    override suspend fun updateUserData(
        dataDTO: EnteredUserDataDTO
    ) {
        return try {
            dao.updateUserData(
                dataDTO.toEnteredDataEntity()
            )
        } catch (e:Exception){
            throw Exception(e.message)
        }
    }

    override suspend fun getDataById(id: Int): EnteredUserDataEntity {
        return try {
            dao.getDataById(id)
        }catch (e:Exception){
            throw Exception("Error: ${e.message}")
        }
    }
}