package di
import android.content.Context
import androidx.room.Room
import data.dao.EnteredUserDataDao
import data.db.AppDatabase



    fun provideDatabaseInstance(
        context:Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ) .build()
    }

    fun provideDao(db:AppDatabase):EnteredUserDataDao{
        return db.dao()
    }