package zed.rainxch.localproverandconnectivitymanager.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import zed.rainxch.localproverandconnectivitymanager.compose_providers.LocalConnectionProvider

@Composable
fun HomeScreen(
    onNavigateToDetails: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val isConnected = LocalConnectionProvider.current
        Column {
            Text("Home", fontSize = 32.sp)

            Text(text = "Is connected $isConnected", fontSize = 32.sp)

            Button(
                onClick = onNavigateToDetails
            ) {
                Text("Go to details screen", fontSize = 32.sp)
            }
        }
    }
}