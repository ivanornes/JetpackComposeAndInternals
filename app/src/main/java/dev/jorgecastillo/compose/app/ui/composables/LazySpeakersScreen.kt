package dev.jorgecastillo.compose.app.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.jorgecastillo.compose.app.R
import dev.jorgecastillo.compose.app.data.FakeSpeakerRepository
import dev.jorgecastillo.compose.app.models.Speaker
import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme

@Composable
fun LazySpeakersScreen(speakers: List<Speaker>) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Speakers")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
            }) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = stringResource(R.string.content_desc_fab_add_speaker),
                    tint = Color.Black
                )
            }

        }, content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .testTag("SpeakersList")
            ) {
                items(speakers) { speaker ->
                    SpeakerCard(speaker, onClick = { _ ->

                    })
                }
            }
        })
}

@Composable
@Preview(showBackground = true)
private fun LazySpeakersScreenPreview() {
    ComposeAndInternalsTheme {
        LazySpeakersScreen(speakers = FakeSpeakerRepository().getSpeakers())
    }
}
