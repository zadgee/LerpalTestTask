package presentation.ui
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import presentation.actions.FirstScreenActions
import presentation.state.FirstScreenState

@Composable
fun FirstScreenComponent(
    modifier: Modifier = Modifier,
    onAction: (FirstScreenActions, Int) -> Unit,
    state: FirstScreenState,
    checkData: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        checkData()
    }

    val name = state.name
    val details = state.details
    val dataId = state.dataId

    BoxWithConstraints(
        modifier = modifier.fillMaxSize()
    ) {
        val isLandscape = maxWidth > maxHeight

        Column(
            verticalArrangement = if (isLandscape) Arrangement.Top else Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(if (isLandscape) 20.dp else 0.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { value ->
                    onAction(
                        FirstScreenActions.OnNameChanged(name = value), dataId
                    )
                },
                placeholder = {
                    Text(
                        text = "Enter name",
                        color = Color.Black
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                isError = state.nameError != null,
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    errorTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
            )

            if (state.nameError != null) {
                Text(
                    text = state.nameError,
                    textAlign = TextAlign.Start,
                    color = Color.Red,
                )
            }

            Spacer(modifier = Modifier.height(
                if (isLandscape) 0.dp else 18.dp
            ))

            OutlinedTextField(
                value = details,
                onValueChange = { value ->
                    onAction(FirstScreenActions.OnDetailsChanged(details = value), dataId)
                },
                placeholder = {
                    Text(
                        text = "Enter details",
                        color = Color.Black
                    )
                },
                isError = state.detailsError != null,
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    errorTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
            )

            if (state.detailsError != null) {
                Text(
                    text = state.detailsError,
                    textAlign = TextAlign.Start,
                    color = Color.Red,
                )
            }

            Spacer(modifier = Modifier.height(
                if (isLandscape) 0.dp else 18.dp
            ))

            Button(
                onClick = {
                    onAction(FirstScreenActions.Submit(dataId = dataId), dataId)
                }
            ) {
                Text(text = "Save data")
            }
        }
    }
}