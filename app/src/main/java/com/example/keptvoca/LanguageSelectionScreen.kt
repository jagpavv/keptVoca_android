package com.example.keptvoca

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectionScreen(onClickLanguage: (selectedLanguage: String) -> Unit) {
//    fun LanguageSelectionScreen(language: String, onClickLanguage: () -> Unit) {
//    }
    val languages: MutableList<String> = mutableListOf("English", "German", "Spanish", "Korean")
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    )
    {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(languages) { item ->
                languageSelectionItem(item, onClickLanguage = onClickLanguage)
            }
        }
    }
}

@Composable
fun languageSelectionItem(language: String, onClickLanguage: (selectedLanguage: String) -> Unit) { //
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClickLanguage(language) })
    ) {
        Row(
            modifier = Modifier.padding(padding),
            horizontalArrangement = Arrangement.spacedBy(padding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f, fill = true),
                verticalArrangement = Arrangement.spacedBy(padding)
            ) {
                Text(
                    text = language,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = language,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

private val padding = 16.dp

@Composable
private fun languageSelectionCard() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        Text(text = "English")
        Text(text = "English")
    }
}
