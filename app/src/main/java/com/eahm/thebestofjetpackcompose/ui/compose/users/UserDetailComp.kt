package com.eahm.thebestofjetpackcompose.ui.compose.users

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.eahm.thebestofjetpackcompose.ui.theme.TheBestOfJetpackComposeTheme


@Composable
fun UserDetailComp(userId: String) {
    Text(text = "Welcome $userId")
}

@Preview
@Composable
fun PreviewUserDetailComp() {
    TheBestOfJetpackComposeTheme {
        UserDetailComp("TestUserId")
    }
}