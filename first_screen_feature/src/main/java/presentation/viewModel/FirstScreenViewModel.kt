package presentation.viewModel
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.models.EnteredUserDataMock
import domain.router.FirstScreenRouter
import domain.usecases.ValidateDetailsUseCase
import domain.usecases.ValidateNameUseCase
import kotlinx.coroutines.launch
import presentation.actions.FirstScreenActions
import presentation.state.FirstScreenState

class FirstScreenViewModel(
    private val router: FirstScreenRouter,
    private val validateNameUseCase: ValidateNameUseCase,
    private val validateDetailsUseCase: ValidateDetailsUseCase
):ViewModel() {

    var state by mutableStateOf(FirstScreenState())
        private set




     fun onAction(
         action:FirstScreenActions,
         dataId:Int
     ){
         when(action){
             is FirstScreenActions.OnDetailsChanged -> {
                 state = state.copy(
                     details = action.details
                 )
             }
             is FirstScreenActions.OnNameChanged -> {
                 state = state.copy(
                     name = action.name
                 )
             }
             is FirstScreenActions.Submit -> submitData(dataId = dataId)
         }
     }


    private fun submitData(
        dataId:Int?
    ):Any {
        val nameResult = validateNameUseCase.isNameValid(
            name = state.name
        )
        val detailsResult = validateDetailsUseCase.isDetailsValid(
            details = state.details
        )
        val hasError = listOf(
            nameResult,
            detailsResult,
        ).any { !it.successful }
        return if (hasError) {
            state = state.copy(
                nameError = nameResult.errorMessage,
                detailsError = detailsResult.errorMessage,
            )
        } else if (dataId != null){
            viewModelScope.launch {
                router.updateUserData(
                    EnteredUserDataMock(
                        name = state.name,
                        details = state.details,
                        detailsSymbolsCount = state.details.count()
                    )
                )
            }
        } else {
            viewModelScope.launch {
                router.insertUserData(
                    EnteredUserDataMock(
                        name = state.name,
                        details = state.details,
                        detailsSymbolsCount = state.details.count()
                    )
                )
            }
        }
    }

    fun checkData(){
        viewModelScope.launch {
            if(state.dataId >= 0){
                Log.d("TAG","bigger than 0 or = 0")
                val data = router.getDataById(id = state.dataId)

                state = state.copy(
                    name = data.name,
                    details = data.details
                )
            } else {
                state = state.copy(
                    name = "",
                    details = ""
                )
            }
        }
    }


}