package presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.compose.viewmodel.koinViewModel
import presentation.viewModel.SecondScreenViewModel

@Composable
fun SecondScreenRoot(
    modifier: Modifier,
    onNavigateBack:(id:Int) -> Unit
){
    val viewModel:SecondScreenViewModel = koinViewModel()
    SecondScreenContent(
        modifier = modifier,
        data = viewModel.state.collectAsLazyPagingItems(),
        onNavigateBack = onNavigateBack
    )
}