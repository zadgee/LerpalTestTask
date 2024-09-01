package presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import domain.models.RetrievedUserData
import domain.router.SecondScreenRouter
import kotlinx.coroutines.flow.Flow

class SecondScreenViewModel(
    router: SecondScreenRouter
):ViewModel() {
    val state:Flow<PagingData<RetrievedUserData>> = router.getRetrievedUserData()
        .cachedIn(viewModelScope)
}