package zed.rainxch.localproverandconnectivitymanager.connectivity_practice.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositionErrors
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.localproverandconnectivitymanager.connectivity_practice.utils.ConnectivityProvider

@Composable
fun ConnectivityPractice(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val viewmodel = viewModel<ConnectivityPracticeViewmodel> {
        ConnectivityPracticeViewmodel(ConnectivityProvider(context))
    }
    val status by viewmodel.state.collectAsState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = status,
                fontSize = 32.sp
            )

            Button(
                onClick = {
                    viewmodel.doSomeAction()
                }
            ) {
                Text("Do call again")
            }
        }
    }

}