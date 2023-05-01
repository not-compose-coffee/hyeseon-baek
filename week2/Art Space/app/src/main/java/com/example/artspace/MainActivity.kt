package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    //ArtSpaceApp()
                }
            }
        }
    }
}



@Composable
fun ArtSpaceScreen(
    modifier: Modifier = Modifier,
    imageResource: Int,
    title: String,
    artist: String,
){
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        ShowGalleryImage(
            imageResource = imageResource,
            modifier = modifier.
            weight(5F)
        )
        Spacer(modifier = modifier.weight(1F))
        ShowTitle(
            title = title,
            artist = artist,
            modifier = modifier.
            weight(2F)
        )
        Spacer(modifier = modifier.weight(1F))
        Row(
            modifier = modifier.weight(1F)
        ){
            Button(
                onClick = {  },
            ) {
                Text(stringResource(R.string.prv_button_text))
            }
            Button(
                onClick = {  },
            ) {
                Text(stringResource(R.string.next_button_text))
            }
        }
    }
}
@Composable
fun ShowGalleryImage(
    modifier: Modifier = Modifier,
    imageResource: Int,
) {
    Image(
        painter = painterResource(imageResource),
        contentDescription = stringResource(R.string.app_name),
        modifier = modifier
            .border(
                width = 2.dp,
                color = colorResource(R.color.black)
            )
            .padding(all = 10.dp)
    )
}

@Composable
fun ShowTitle(
    modifier: Modifier = Modifier,
    title: String,
    artist: String
) {
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = artist
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
    }
}