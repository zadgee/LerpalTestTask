package presentation.ui
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.resourceinspection.annotation.Attribute.IntMap
import org.koin.compose.viewmodel.koinViewModel
import presentation.viewModel.FirstScreenViewModel

@Composable
fun FirstScreenRoot(
    modifier: Modifier,
    dataId:Int,
){
    val viewModel:FirstScreenViewModel = koinViewModel()
    val state = viewModel.state
    state.dataId = dataId


    FirstScreenComponent(
        modifier = modifier, onAction = viewModel::onAction , state = state,
        checkData = {
            viewModel.checkData()
        }
    )
}