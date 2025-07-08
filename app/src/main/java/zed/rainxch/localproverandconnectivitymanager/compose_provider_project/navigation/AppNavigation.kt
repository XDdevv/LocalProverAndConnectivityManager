package zed.rainxch.localproverandconnectivitymanager.compose_provider_project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import zed.rainxch.localproverandconnectivitymanager.compose_provider_project.details.DetailsScreen
import zed.rainxch.localproverandconnectivitymanager.compose_provider_project.home_screen.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavGraph.HomeScreen
    ) {
        composable<NavGraph.HomeScreen> {
            HomeScreen(
                onNavigateToDetails = {
                    navController.navigate(NavGraph.DetailsScreen(detail = "From home screen"))
                }
            )
        }

        composable<NavGraph.DetailsScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<NavGraph.DetailsScreen>()

            DetailsScreen(
                detail = args.detail
            )
        }
    }
}