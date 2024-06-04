package ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Any())
    val uiState: StateFlow<Any> = _uiState.asStateFlow()
}