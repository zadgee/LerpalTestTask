package com.example.lerpaltesttask.navigation
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import presentation.ui.FirstScreenRoot
import presentation.ui.SecondScreenRoot

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(
    modifier:Modifier
){
    val navController = rememberNavController()
    val screens = listOf(
        BottomBarScreens.FirstScreen,
        BottomBarScreens.SecondScreen
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar {
                screens.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(screen.route)
                            if(selectedItemIndex != index){
                                navController.popBackStack()
                            }
                        }, icon = {
                            Icon(
                                imageVector = if(index == selectedItemIndex){
                                    screen.selectedIcon
                                } else screen.unselectedIcon, contentDescription = screen.title
                            )
                        }
                    )
                }
            }
        }
    ){
        NavHost(
            navController = navController,
            startDestination = Routes.FIRST_SCREEN
        ) {
            composable(
                route = Routes.FIRST_SCREEN,
                arguments = listOf(
                    navArgument("data_id"){
                        type = NavType.IntType
                        defaultValue = -1
                    }
                )
            ){ backStackEntry->
                val dataId = backStackEntry.savedStateHandle.getStateFlow(
                    "data_id",
                    initialValue = -1,
                ).collectAsState()
                Log.d("TAG","dataId:$dataId")
                selectedItemIndex = 0
                FirstScreenRoot(
                    modifier = modifier,
                    dataId = dataId.value
                )
                DisposableEffect(key1 = dataId) {
                    onDispose {
                        dataId.value -1
                    }
                }
            }

            composable(Routes.SECOND_SCREEN){
                selectedItemIndex = 1
                SecondScreenRoot(
                    modifier = modifier,
                    onNavigateBack = { id->
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "data_id",
                            id,
                        )
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

