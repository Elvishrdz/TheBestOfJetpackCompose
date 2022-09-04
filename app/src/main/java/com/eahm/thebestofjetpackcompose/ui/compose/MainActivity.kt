package com.eahm.thebestofjetpackcompose.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.eahm.thebestofjetpackcompose.domain.model.MenuItem
import com.eahm.thebestofjetpackcompose.ui.navigation.CodeLabDirections
import com.eahm.thebestofjetpackcompose.ui.navigation.UserDirections
import com.eahm.thebestofjetpackcompose.ui.theme.TheBestOfJetpackComposeTheme

object MainMenuList {
    val menuList = listOf(
        MenuItem(
            title = "Jetpack Compose CodeLab",
            description = "State in Compose and State Hoisting",
            direction = CodeLabDirections.CodeLab1.route
        ),
        MenuItem(
            title = "Compose and Navigation",
            description = "We get a list of users and we can see details of each one in a single composable view",
            direction = UserDirections.UserList.route
        )
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheBestOfJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Tamara")
                    //Conversation(messages = SampleData.conversationSample)
                    NavHostingComposition()
                }
            }
        }
    }
}
