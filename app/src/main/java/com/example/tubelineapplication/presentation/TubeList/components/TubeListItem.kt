package com.example.tubelineapplication.presentation.TubeList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tubelineapplication.domain.model.TubeLineList

@Composable
fun TubeListItem(
    tubeLineList: TubeLineList,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick() },
        shape = RoundedCornerShape(8.dp),
        //elevation = 4.dp
        //backgroundColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Text(
                text = tubeLineList.name ?: "",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Mode: ${tubeLineList.modeName ?: ""}",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = "ID: ${tubeLineList.id ?: ""}",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = "Modified: ${tubeLineList.modified ?: ""}",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Text(
                text = "Created: ${tubeLineList.created ?: ""}",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
        }
    }
}

