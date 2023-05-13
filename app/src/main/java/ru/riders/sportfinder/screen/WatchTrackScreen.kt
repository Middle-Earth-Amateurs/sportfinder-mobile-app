package ru.riders.sportfinder.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.yandex.mapkit.geometry.Point
import ru.riders.sportfinder.MainActivityViewModel
import ru.riders.sportfinder.R
import ru.riders.sportfinder.data.TrackInfo
import ru.riders.sportfinder.screen.widget.JCMapView
import ru.riders.sportfinder.ui.theme.LightGreen


@Composable
fun WatchTrackScreen(
    viewModel: MainActivityViewModel?,
    navHostController: NavHostController?,
    trackInfo: TrackInfo,

) {
    lateinit var mapView: JCMapView
    val (name, distance, tempOnStart, tags, points, tempOnEnd) = trackInfo
    Column {
        AndroidView(
            modifier = Modifier
                .fillMaxSize(),
            factory = { context ->
                mapView = JCMapView(
                    context,
                    { _, _ -> },
                    { _, _ -> }
                )
                mapView
            })
        Column(
            modifier = Modifier.padding(top = 8.dp, start = 12.dp, bottom = 4.dp)
        ) {
            val trackIconsAttributesModifier = Modifier.padding(end = 8.dp)
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_map_marker_white_24),
                    contentDescription = "Map sign",
                    tint = LightGreen,
                    modifier = trackIconsAttributesModifier
                )
                Text(
                    text = "Расстояние: ",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = distance.toString() + "Km",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_route_white_24),
                    contentDescription = "route sign",
                    tint = LightGreen,
                    modifier = trackIconsAttributesModifier
                )
                Text(
                    text = "Дистанция: ",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = distance.toString() + "Km",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_weather_white_24),
                    contentDescription = "Temperature sign",
                    tint = LightGreen,
                    modifier = trackIconsAttributesModifier
                )
                Text(
                    text = "Погода в начальной точке: ",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = if (tempOnStart > 0) "+" + tempOnStart.toString() + "C"
                    else tempOnStart.toString() + "C",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_weather_white_24),
                    contentDescription = "Temperature sign",
                    tint = LightGreen,
                    modifier = trackIconsAttributesModifier
                )
                Text(
                    text = "Погода в конечной точке: ",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = if (tempOnEnd > 0) "+" + tempOnEnd.toString() + "C"
                    else tempOnEnd.toString() + "C",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}


@Composable
@Preview
fun WatchTrackScreenPreview(){
    WatchTrackScreen(
        null, null, TrackInfo("Маршрут 1",
            2.3,
            80,
            listOf("В горку"),
            listOf(Point(2.3, 2.4)), -3, 111
        ),)
}