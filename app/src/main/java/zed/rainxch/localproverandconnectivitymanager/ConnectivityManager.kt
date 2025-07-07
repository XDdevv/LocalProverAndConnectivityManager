package zed.rainxch.localproverandconnectivitymanager

import kotlinx.coroutines.flow.Flow

interface ConnectivityManager {
    val isConnected: Flow<Boolean>
}