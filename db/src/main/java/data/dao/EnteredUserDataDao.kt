package data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import data.entities.EnteredUserDataEntity

@Dao
interface EnteredUserDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserData(data:EnteredUserDataEntity)

    @Query("SELECT * FROM entered_user_data_table WHERE id =:id")
    suspend fun getDataById(id:Int):EnteredUserDataEntity

    @Query("SELECT * FROM entered_user_data_table")
    fun dataPagingSource():PagingSource<Int, EnteredUserDataEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserData(data:EnteredUserDataEntity)
}