package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard(
        profilePainter = painterResource(R.drawable.android),
        name = stringResource(R.string.main_card_name),
        description = stringResource(R.string.main_card_description),
        telNum = stringResource(R.string.main_card_tel),
        gitId = stringResource(R.string.main_card_id),
        email = stringResource(R.string.main_card_email)
    )
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier,
    profilePainter: Painter,
    name: String,
    description: String,
    telNum: String,
    gitId: String,
    email: String
) {
    val imageModifier = Modifier
        .size(30.dp)
    Column(
        modifier = modifier.fillMaxSize()
            .background(colorResource(R.color.sky_blue)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.weight(2F)
        ) {
        }
        Box(
            modifier = Modifier.weight(5F)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = profilePainter,
                    contentScale = ContentScale.Fit,
                    contentDescription = stringResource(R.string.main_card_description)
                )
                Text(
                    text = name,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(bottom = 15.dp),
                    fontSize = 30.sp
                )
                Text(
                    text = description,
                    fontSize = 15.sp
                )
            }
        }
        Box(
            modifier = Modifier.weight(1F)
        ) {
        }
        Box(
            modifier = Modifier.weight(4F)
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.telephone),
                        contentScale = ContentScale.Fit,
                        modifier = imageModifier,
                        contentDescription = stringResource(R.string.main_card_description)
                    )
                    Text(
                        text = telNum,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(all=10.dp),
                        fontSize = 20.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.git),
                        contentScale = ContentScale.Fit,
                        modifier = imageModifier,
                        contentDescription = stringResource(R.string.main_card_description)
                    )
                    Text(
                        text = gitId,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(all=10.dp),
                        fontSize = 20.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.gmail),
                        contentScale = ContentScale.Fit,
                        modifier = imageModifier,
                        contentDescription = stringResource(R.string.main_card_description)
                    )
                    Text(
                        text = email,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(all=10.dp),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardApp()
}