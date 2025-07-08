package zed.rainxch.localproverandconnectivitymanager.compose_provider_project

import kotlinx.coroutines.flow.Flow

interface ConnectivityManager {
    val isConnected: Flow<Boolean>
}