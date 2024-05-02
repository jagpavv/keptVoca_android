package com.example.keptvoca

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordListScreen(selectedLanguage: String) { // TODO: navigateUp: () -> Unit
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("user Detail screen $selectedLanguage") }
            )
        },
        content = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$selectedLanguage", fontSize = 30.sp)
            }
        }
    )
}

//private fun UserDetailBox(user: UserDetail, navigateUp: () -> Unit) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("user Detail screen") },
//                navigationIcon = {
//                    IconButton(onClick =  { navigateUp() }) {
//                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        },
//        content = {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "${user.loginId}", fontSize = 30.sp)
//            }
//        }
//    )
//}