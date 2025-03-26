package com.rubykamboj.anime.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.rubykamboj.anime.ui.screen.anime.details.AnimeDetailsScreen
import com.rubykamboj.anime.ui.screen.home.HomeScreen

val LocalNavController = compositionLocalOf<NavController> {
    error("No NavController provided")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home,
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
            },
        ) {
            composable<Screen.Home> {
                HomeScreen()
            }
            composable<Screen.AnimeDetails> {
                val route = it.toRoute<Screen.AnimeDetails>()
                AnimeDetailsScreen(route)
            }
        }
    }
}