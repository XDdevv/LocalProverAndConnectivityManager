package zed.rainxch.localproverandconnectivitymanager.compose_provider_project.navigation

import kotlinx.serialization.Serializable

sealed interface NavGraph {
    @Serializable
    data object HomeScreen : NavGraph
    @Serializable
    data class DetailsScreen(val detail: String) : NavGraph
}