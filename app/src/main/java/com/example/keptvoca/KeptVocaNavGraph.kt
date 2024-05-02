package com.example.keptvoca

import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.keptvoca.KeptVocaScreens.WORD_LIST_SCREEN
import androidx.compose.runtime.remember

private object KeptVocaScreens {
    const val LANGUAGE_LIST_SCREEN = "languages"
    const val WORD_LIST_SCREEN = "wordList"
}

private const val SELECTED_LANGUAGE = "language"

object KeptVocaDestinations {
    const val WORD_LIST_ROUTE = "$WORD_LIST_SCREEN/{$SELECTED_LANGUAGE}"
}

@Composable
// TODO:  Question NavHost vs NavGraph?
fun KeptVocaNavGraph(
    navController: NavHostController = rememberNavController(),
    navActions: KeptVocaNavigationActions = remember(navController) {
        KeptVocaNavigationActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = KeptVocaScreens.LANGUAGE_LIST_SCREEN,
    ) {
        composable(route = KeptVocaScreens.LANGUAGE_LIST_SCREEN) {
            LanguageSelectionScreen(
                onClickLanguage = { language ->
                    navActions.navigateToLanguageList(language)
                }
            )
        }
        composable(
            route =  KeptVocaDestinations.WORD_LIST_ROUTE,
            arguments = listOf(
                navArgument(SELECTED_LANGUAGE) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val arguments = navBackStackEntry.arguments ?: return@composable run {
                //TODO: when it fails
            }
            WordListScreen(
                selectedLanguage = arguments.getString(SELECTED_LANGUAGE)!!
            )
        }
    }
}

class KeptVocaNavigationActions(private val navController: NavHostController) {
    fun navigateToLanguageList(language: String) {
        navController.navigate(route = "$WORD_LIST_SCREEN/$language")
    }
}