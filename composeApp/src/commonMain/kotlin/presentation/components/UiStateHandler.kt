package presentation.components

import androidx.compose.runtime.Composable
import presentation.base.Result

@Composable
fun <T> UiStateHandler(
    result: Result<T>,
    onSuccess: @Composable (data: T) -> Unit
) {
    when (result) {
        is Result.Loading -> ProgressIndicator()
        is Result.Error -> {}
        is Result.Success -> onSuccess(result.data)
    }
}