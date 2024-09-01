package com.example.lerpaltesttask.glue.second_screen_feature
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.viewModel.SecondScreenViewModel

val secondScreenModule = module {
    single { provideSecondScreenRouter(get()) }
}

val secondScreenViewModelModule = module {
    viewModel { SecondScreenViewModel(get()) }
}