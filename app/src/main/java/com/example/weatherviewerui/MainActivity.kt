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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    var city by remember {mutableStateOf("Boston, MA, US")}
    val brightBlue = Color(0xFF0096FF)

    Column (
        modifier = modifier.fillMaxSize().padding(horizontal=16.dp)
    ) {
        TextField(
            value = city,
            onValueChange = {city = it},
            textStyle = TextStyle(fontSize = 18.sp),
            modifier = Modifier.fillMaxWidth(),
            label = {Text("Enter city (e.g, Boston, MA, US)")},
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.rounded_checkmark),
                    contentDescription = "Rounded checkmark",
                    modifier = Modifier.size(60.dp).offset(y = 27.5.dp)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = brightBlue,
                unfocusedIndicatorColor = brightBlue,
                focusedLabelColor = brightBlue,
                unfocusedLabelColor = brightBlue,
            ),
        )

        WeatherRow(
            day = "Tuesday",
            description = "sky is clear",
            low = "71 F",
            high = "81 F",
            humidity = "67%",
            icon = R.drawable.weatherviewer_app_icon1
        )
        WeatherRow(
            day = "Wednesday",
            description = "sky is clear",
            low = "66 F",
            high = "79 F",
            humidity = "68%",
            icon = R.drawable.weatherviewer_app_icon1
        )
        WeatherRow(
            day = "Thursday",
            description = "sky is clear",
            low = "63 F",
            high = "80 F",
            humidity = "69%",
            icon = R.drawable.weatherviewer_app_icon1
        )
        WeatherRow(
            day = "Friday",
            description = "sky is clear",
            low = "63 F",
            high = "78 F",
            humidity = "71%",
            icon = R.drawable.weatherviewer_app_icon1
        )
        WeatherRow(
            day = "Saturday",
            description = "moderate rain",
            low = "68 F",
            high = "72 F",
            humidity = "0%",
            icon = R.drawable.weatherviewer_app_icon2
        )
        WeatherRow(
            day = "Sunday",
            description = "very heavy rain",
            low = "65 F",
            high = "70 F",
            humidity = "0%",
            icon = R.drawable.weatherviewer_app_icon2
        )
        WeatherRow(
            day = "Monday",
            description = "very heavy rain",
            low = "58 F",
            high = "65 F",
            humidity = "0%",
            icon = R.drawable.weatherviewer_app_icon2
        )
        WeatherRow(
            day = "Tuesday",
            description = "light rain",
            low = "58 F",
            high = "65 F",
            humidity = "0%",
            icon = R.drawable.weatherviewer_app_icon2
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
                    fontSize = 22.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = "Low: $low",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        text = "High: $high",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        text = "Humidity: $humidity",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
    HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.LightGray)
}

