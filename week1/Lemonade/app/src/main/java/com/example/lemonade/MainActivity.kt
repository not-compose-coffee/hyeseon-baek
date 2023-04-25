package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(){
    LemonadeCard()
}
@Composable
fun LemonadeCard(
    modifier: Modifier = Modifier,
) {
    val result = remember {
        mutableStateOf(1)
    }
    var imageResource: Int = R.drawable.lemon_tree
    var description : Int = R.string.firstTap_string
    when (result.value) {
        1 -> {
            imageResource = R.drawable.lemon_tree
            description = R.string.firstTap_string
        }
        2 -> {
            imageResource = R.drawable.lemon_squeeze
            description = R.string.secondTap_string
        }
        3 -> {
            imageResource = R.drawable.lemon_drink
            description = R.string.thirdTap_string
        }
        4 -> {
            imageResource = R.drawable.lemon_restart
            description = R.string.fourthTap_string
        }
    }

    Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(description),
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(R.string.app_name),
                modifier = modifier
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(4.dp),
                        color = colorResource(R.color.corner_color)
                    )
                    .clickable {
                        if (result.value == 4) {
                            result.value = 1
                        } else {
                            result.value++
                        }
                    }
            )
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeApp()
}