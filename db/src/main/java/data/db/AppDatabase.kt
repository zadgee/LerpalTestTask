package data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import data.dao.EnteredUserDataDao
import data.entities.EnteredUserDataEntity

@Database(
    entities = [
        EnteredUserDataEntity::class
    ],
    exportSchema = true,
    version = 2,
    autoMigrations = [
        AutoMigration(
            from = 1, to = 2, spec = AppDatabase.MigrationSpec_1_2::class
        ),
    ]
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun dao(): EnteredUserDataDao
    class MigrationSpec_1_2: AutoMigrationSpec
}