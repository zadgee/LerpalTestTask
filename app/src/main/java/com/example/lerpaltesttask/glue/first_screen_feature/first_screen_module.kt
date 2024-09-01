package com.example.lerpaltesttask.glue.first_screen_feature
import com.example.lerpaltesttask.glue.first_screen_feature.domain.provideValidateDetailsUseCase
import com.example.lerpaltesttask.glue.first_screen_feature.domain.provideValidateNameUseCase
import com.example.lerpaltesttask.glue.first_screen_feature.router.provideFirstScreenRouter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.viewModel.FirstScreenViewModel

val firstScreenModule = module {
    single { provideFirstScreenRouter(get(), get(), get()) }
    single { provideValidateNameUseCase() }
    single { provideValidateDetailsUseCase() }
}
val firstScreenViewModelModule = module {
    viewModel{ FirstScreenViewModel(
        router = get(),
        validateNameUseCase = get(),
        validateDetailsUseCase = get()
    ) }
}