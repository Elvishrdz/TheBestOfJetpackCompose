package com.eahm.thebestofjetpackcompose.ui.navigation

sealed class AppDirections (val route : String){
    object MainMenu : AppDirections("main_menu")
}

sealed class CodeLabDirections(val route : String){
    object CodeLab1 : CodeLabDirections("compose_code_lab_1")
}

sealed class UserDirections(val route : String){

    object UserList : UserDirections(viewUserList)

    object UserDetail : UserDirections("$viewUserDetail/{userId}/$viewDetails"){
        fun createRoute(userId : String) = "$viewUserDetail/$userId/$viewDetails"
    }

    object UserContact : UserDirections("$viewUserDetail/{userId}/$viewContact"){
        fun createRoute(userId : String) = "$viewUserDetail/$userId/$viewContact"
    }
}

private const val viewUserList = "user_list"
private const val viewUserDetail = "user_detail"

private const val viewDetails = "details"
private const val viewContact = "contact"
