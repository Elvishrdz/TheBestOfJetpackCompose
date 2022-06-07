package com.eahm.thebestofjetpackcompose.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.eahm.thebestofjetpackcompose.R
import com.eahm.thebestofjetpackcompose.domain.model.MenuItem
import com.eahm.thebestofjetpackcompose.ui.theme.TheBestOfJetpackComposeTheme

@Composable
fun MenuList(menus: List<MenuItem>, onItemSelected : ((direction: String) -> Unit)? = null) {
    Column () {
        Text(
            text = "JETPACK COMPOSE EXPERIMENTS",
            fontSize = 27.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 7.dp,
                    start = 3.dp,
                    end = 3.dp,
                    bottom = 7.dp
                )
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn{
            items(menus){ menu ->
                Card(
                    elevation = 7.dp,
                    backgroundColor = colorResource(id = R.color.white),
                    modifier = Modifier
                        .padding(5.dp)
                        .clickable {
                            onItemSelected?.invoke(menu.direction)
                        }
                ) {
                    Column(
                        modifier = Modifier.padding(7.dp)
                    ) {
                        Text(text = menu.title)
                        Text(
                            text = menu.description,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }

    }


}

@Preview
@Composable
fun PreviewMenuList(){
    TheBestOfJetpackComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MenuList(menus = MainMenuList.menuList)
        }
    }
}
