package zed.rainxch.localproverandconnectivitymanager.compose_provider_project.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import zed.rainxch.localproverandconnectivitymanager.compose_provider_project.compose_providers.LocalConnectionProvider

@Composable
fun DetailsScreen(
    detail: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val isConnected = LocalConnectionProvider.current
        Column {
            Text("Details screen", fontSize = 32.sp)
            Text("Detail value : $detail", fontSize = 32.sp)

            Text(text = "Is connected $isConnected", fontSize = 32.sp)
        }
    }
}