package data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "entered_user_data_table",
)
data class EnteredUserDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String,
    val details:String,
    val detailsSymbolsCount:Int
)