package com.example.weatherviewerui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherviewerui.ui.theme.WeatherViewerUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherScreen()

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun WeatherScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title={Text("WeatherViewer")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor=Color.Blue,
                    titleContentColor=Color.White,
                    )
            )
        }
    ) {
        padding -> WeatherView(modifier = Modifier.padding(paddingValues=padding))
    }
}

@Composable
fun WeatherView(modifier: Modifier = Modifier) {
    var city by remember {mutableStateOf("Boston")}
    Column (
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        OutlinedTextField(
            value = city,
            onValueChange = {city = it},
            label = {Text("Enter city name")},
            modifier = Modifier.fillMaxWidth()
        )
        WeatherRow(
            day = "Tuesday",
            description = "sky is clear",
            low = "71",
            high = "81",
            humidity = "67%",
            icon = R.drawable.weatherviewer_app_icon1
        )
    }
}

@Composable
fun WeatherRow(
    day: String,
    description: String,
    low: String,
    high: String,
    humidity: String,
    icon: Int,
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = description,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "$day: $description",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Low: $low High: $high Humidity: $humidity",
                    fontSize = 16.sp,
                )
            }
        }
    }
    HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.LightGray)
}

