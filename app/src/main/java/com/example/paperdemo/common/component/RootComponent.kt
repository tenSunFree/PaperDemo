package com.example.paperdemo.common.component

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.paperdemo.common.model.Destinations
import com.example.paperdemo.home.view.HomeScreen
import com.example.paperdemo.common.theme.PaperTheme
import com.example.paperdemo.common.theme.isSystemInDarkThemeCustom

@ExperimentalMaterialNavigationApi
@ExperimentalMaterialApi
@Composable
fun RootComponent() {

    val isDark = isSystemInDarkThemeCustom()
    val systemUiController = rememberSystemUiController()

    PaperTheme(isDark) {
        val darkIcons = MaterialTheme.colors.isLight
        SideEffect { systemUiController.setSystemBarsColor(Color.Transparent, darkIcons) }
        Surface(color = MaterialTheme.colors.background) {
            val scrollState = rememberLazyListState()
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController = rememberNavController(bottomSheetNavigator)
            ModalBottomSheetLayout(bottomSheetNavigator) {
                NavHost(
                    navController = navController,
                    startDestination = Destinations.HOME_ROUTE
                ) {
                    composable(Destinations.HOME_ROUTE) {
                        HomeScreen(scrollState)
                    }
                }
            }
        }
    }
}
