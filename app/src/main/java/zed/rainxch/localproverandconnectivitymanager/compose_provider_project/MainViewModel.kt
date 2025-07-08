package zed.rainxch.localproverandconnectivitymanager.compose_provider_project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    private val connectivityManager: ConnectivityManager,
) : ViewModel() {

    val connected = connectivityManager
        .isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            false
        )
}