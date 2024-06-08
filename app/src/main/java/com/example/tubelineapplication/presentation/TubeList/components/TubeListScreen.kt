package com.example.tubelineapplication.presentation.TubeList.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tubelineapplication.domain.model.TubeLineList
import com.example.tubelineapplication.presentation.ui.Screen

@Composable
fun TubeListScreen (
    viewModel: TubeListViewModel = hiltViewModel(),
    navController: NavController

){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn (modifier = Modifier.fillMaxSize()){
            items(state.tubeLines){ TubeLineList ->
                TubeListItem(
                    TubeLineList = TubeLineList(),
                    onItemClick = {
                        navController.navigate(Screen.TubeListScreen.route + "/${TubeLineList.id}")
                        //  "/${capsule.capsuleId}"
                    }

                )
            }
        }
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                //color = MaterialTheme.colorScheme,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}