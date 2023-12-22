package com.example.pipinglinkup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pipinglinkup.ui.theme.PipingLinkUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PipingLinkUpTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    PipeGrid()
                }
            }
        }
    }
}

@Preview
@Composable
fun PipeGrid(modifier: Modifier = Modifier) {
    val rows = 0..7
    val columns = 0..3
    Column (modifier = modifier
        .fillMaxSize()) {
        rows.forEach{ j ->
            Row (modifier = modifier
                .fillMaxWidth()) {
                columns.forEach { i ->
                    var orient by remember {
                        mutableStateOf(i % 4)
                    }
                    Image(
                        painter = painterResource(R.drawable.pipe_piece),
                        contentDescription = null,
                        modifier = Modifier
                            .size(90.dp)
                            .padding(4.dp)
                            .rotate(90f * orient)
                            .clickable {
                                orient = (orient + 1) % 4
                            }
                    )
                }
            }
        }
    }
}