package com.eahm.thebestofjetpackcompose.ui.navigation

sealed class AppDirections (val route : String){
    object MainMenu : AppDirections("main_menu")
}

sealed class CodeLabDirections(val route : String){
    object CodeLab1 : CodeLabDirections("compose_code_lab_1")
}

sealed class UserDirections(val route : String){

    object UserList : UserDirections("user_list")

    object UserDetail : UserDirections("user_detail/{userId}/details"){
        fun createRoute(userId : String) = "user_detail/$userId/details"
    }
    object UserContact : UserDirections("user_detail/{userId}/contact"){
        fun createRoute(userId : String) = "user_detail/$userId/contact"
    }
}


