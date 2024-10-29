package dev.jorgecastillo.compose.app.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Speakers App") })
    }, content = { padding ->
        val navController = rememberNavController()

        NavHost(
            modifier = Modifier.padding(padding),
            navController = navController,
            startDestination = "speakers") {
            composable("speakers") {
                SpeakerFeed  { speaker ->
                    navController.navigate("speaker/${speaker.id}") {
                        popUpTo("speakers")
                    }
                }
            }
            composable("speaker/{speakerId}") {
                SpeakerProfileScreen(it.arguments?.getString("speakerId"))
            }
        }
    })
}
