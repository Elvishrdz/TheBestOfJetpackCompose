package com.eahm.thebestofjetpackcompose.ui.compose.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eahm.thebestofjetpackcompose.domain.model.User
import com.eahm.thebestofjetpackcompose.ui.theme.TheBestOfJetpackComposeTheme

val userList = listOf(
    User(
        id = "1A",
        name = "Daniel",
        lastName = "Medina",
        phone = "+451532252567",
        hobbies = "Sport, Videogames, Programming"
    ),
    User(
        id = "2B",
        name = "Pablo",
        lastName = "Ortiz",
        phone = "+45215615489",
        hobbies = "Movies, Fitness, Meditation"
    ),
    User(
        id = "3C",
        name = "Sara",
        lastName = "Daniels",
        phone = "+45854785123",
        hobbies = "Yoga, Karate, Maths"
    ),
)

@Composable
fun UserListComp(showUserDetails: ((userId : String) -> Unit)? = null) {
    LazyColumn{
        items(userList){ user ->
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable{
                        showUserDetails?.invoke(user.id)
                    }
            ) {
                Column {
                    Text(
                        text = "${user.name} ${user.lastName}",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(7.dp)
                    )
                    Text(
                        text = user.hobbies,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(7.dp)
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun PreviewUserListComp() {
    TheBestOfJetpackComposeTheme {
        UserListComp()
    }
}

