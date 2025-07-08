package zed.rainxch.localproverandconnectivitymanager.connectivity_practice.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.core.content.getSystemService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConnectivityProvider(
    private val context: Context,
) {
    private val connectivityManager = context.getSystemService<ConnectivityManager>()

    private val _isConnected = MutableStateFlow(false)
    val isConnected = _isConnected.asStateFlow()

    init {
        initializeNetworkCallback()
    }

    private fun initializeNetworkCallback() {
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                _isConnected.tryEmit(true)
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities,
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                val isConnected = networkCapabilities.hasCapability(
                    NetworkCapabilities.NET_CAPABILITY_VALIDATED
                )
                _isConnected.tryEmit(isConnected)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                _isConnected.tryEmit(false)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                _isConnected.tryEmit(false)
            }
        }

        connectivityManager?.registerDefaultNetworkCallback(networkCallback)
    }


}