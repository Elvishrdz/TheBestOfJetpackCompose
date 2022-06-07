package com.eahm.thebestofjetpackcompose.ui.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eahm.thebestofjetpackcompose.R
import com.eahm.thebestofjetpackcompose.ui.theme.TheBestOfJetpackComposeTheme

@Composable
fun Greeting(name: String) {
    Row (modifier = Modifier.padding(all = 5.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(size = 50.dp)
                .clip(shape = RoundedCornerShape(size = 7.dp))
                .border(
                    width = 1.5.dp,
                    color = MaterialTheme.colors.secondary,
                    shape = RoundedCornerShape(size = 7.dp)
                )
        )
        Spacer(modifier = Modifier.width(8.dp))





        Column {
            Text(text = "Hello $name!", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h1, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = "Hola $name!", style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}

@Preview(
    name = "Light Mode"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    TheBestOfJetpackComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Greeting("Tamara")
        }
    }
}