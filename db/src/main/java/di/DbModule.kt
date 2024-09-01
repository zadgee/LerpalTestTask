package di

import org.koin.dsl.module

val dbModule = module{
    single { provideDatabaseInstance(get()) }
    single { provideDao(get()) }
    single { provideUserDataRepositoryImpl(get()) }
    single { provideInsertDataUseCase(get()) }
    single { provideGetAllDataUseCase(get()) }
    single { provideUpdateUserDataUseCase(get()) }
    single { provideGetDataByIdUseCase(get()) }
}