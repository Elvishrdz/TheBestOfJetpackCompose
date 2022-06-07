package com.eahm.thebestofjetpackcompose.ui.compose

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eahm.thebestofjetpackcompose.ui.compose.codelabs.ComposeCodeLab1
import com.eahm.thebestofjetpackcompose.ui.compose.codelabs.ComposeCodeLab2
import com.eahm.thebestofjetpackcompose.ui.compose.users.UserDetailComp
import com.eahm.thebestofjetpackcompose.ui.compose.users.UserListComp
import com.eahm.thebestofjetpackcompose.ui.navigation.AppDirections
import com.eahm.thebestofjetpackcompose.ui.navigation.CodeLabDirections
import com.eahm.thebestofjetpackcompose.ui.navigation.UserDirections

@Composable
fun NavHostingComposition(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDirections.MainMenu.route
    ){

        composable(route = AppDirections.MainMenu.route){
            MenuList(
                menus = MainMenuList.menuList,
                onItemSelected = { direction ->
                    navController.navigate(direction)
                }
            )
        }

        composable(route = CodeLabDirections.CodeLab1.route){

            //  by = Este es un delegado de propiedad para que no debas escribir .value cada vez.
            // rememberSaveable == Esto guardará todos los estados que sobrevivan a los cambios de configuración (como las rotaciones) y el cierre del proceso.
            var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
            // remember == cuando se rota la pantalla se pierde el valor actual

            if(shouldShowOnboarding){
                ComposeCodeLab2(onContinueClicked = { shouldShowOnboarding = false })
            }
            else {
                ComposeCodeLab1()
            }
        }


        composable(route = UserDirections.UserList.route){
            UserListComp(
                showUserDetails = { userId ->
                    navController.navigate(UserDirections.UserDetail.createRoute(userId))
                }
            )
        }

        composable(route = UserDirections.UserDetail.route){ navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getString("userId")
            requireNotNull(userId){
                "User ID can not be null, always provide one"
            }
            UserDetailComp(userId)
        }

    }
}
