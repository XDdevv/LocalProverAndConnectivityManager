package zed.rainxch.localproverandconnectivitymanager.navigation

import kotlinx.serialization.Serializable

sealed interface NavGraph {
    @Serializable
    data object HomeScreen : NavGraph
    @Serializable
    data class DetailsScreen(val detail: String) : NavGraph
}