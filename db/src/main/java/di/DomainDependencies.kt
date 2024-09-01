package di

import data.dao.EnteredUserDataDao
import data.impl.UserDataRepositoryImpl
import domain.repo.UserDataRepository
import domain.usecases.GetAllDataUseCase
import domain.usecases.GetDataByIdUseCase
import domain.usecases.InsertUserDataUseCase
import domain.usecases.UpdateUserDataUseCase

fun provideUserDataRepositoryImpl(
    dao: EnteredUserDataDao
): UserDataRepository {
    return UserDataRepositoryImpl(dao)
}

fun provideInsertDataUseCase(
    repository: UserDataRepository
):InsertUserDataUseCase{
    return InsertUserDataUseCase(
        repository
    )
}

fun provideGetAllDataUseCase(
    repository: UserDataRepository
): GetAllDataUseCase{
    return GetAllDataUseCase(
        repository
    )
}

fun provideUpdateUserDataUseCase(
    repository: UserDataRepository
): UpdateUserDataUseCase{
    return UpdateUserDataUseCase(
        repository
    )
}

fun provideGetDataByIdUseCase(
    repository: UserDataRepository
): GetDataByIdUseCase {
      return GetDataByIdUseCase(
          repository
      )
}