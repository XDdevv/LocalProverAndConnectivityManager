package zed.rainxch.localproverandconnectivitymanager.connectivity_practice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import zed.rainxch.localproverandconnectivitymanager.connectivity_practice.utils.ConnectivityProvider

class ConnectivityPracticeViewmodel(
    private val connectivityProvider: ConnectivityProvider,
) : ViewModel() {

    private val _state = MutableStateFlow("")
    val state = _state.asStateFlow()

    fun doSomeAction() {
        _state.update { "Loading..." }
        viewModelScope.launch {
            connectivityProvider.isConnected.collect { isConnected ->
                if (isConnected) {
                    _state.update { "Requesting..." }
                    delay(10000)
                    _state.update { "Success" }
                } else {
                    _state.update { "Lost connection" }
                }
            }
        }
    }

}