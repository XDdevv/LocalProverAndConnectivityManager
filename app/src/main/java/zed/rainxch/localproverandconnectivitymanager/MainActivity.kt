package zed.rainxch.localproverandconnectivitymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.localproverandconnectivitymanager.compose_providers.LocalConnectionProvider
import zed.rainxch.localproverandconnectivitymanager.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val viewModel = viewModel<MainViewModel> {
                MainViewModel(
                    AndroidConnectivityManager(context)
                )
            }
            val connected by viewModel.connected.collectAsStateWithLifecycle()

            CompositionLocalProvider(LocalConnectionProvider provides connected) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }

        }
    }
}