package zed.rainxch.localproverandconnectivitymanager.compose_providers

import androidx.compose.runtime.compositionLocalOf

val LocalConnectionProvider = compositionLocalOf<Boolean> {
    error("Connection is not provided")
}