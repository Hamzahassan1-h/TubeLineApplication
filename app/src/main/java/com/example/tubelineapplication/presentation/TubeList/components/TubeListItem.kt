package com.example.tubelineapplication.presentation.TubeList.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
            .padding(vertical = 8.dp)
            .clickable { onItemClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tubeLineList.name ?: "",
                    style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Mode: ${tubeLineList.modeName ?: ""}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "ID: ${tubeLineList.id ?: ""}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Modified: ${tubeLineList.modified ?: ""}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Created: ${tubeLineList.created ?: ""}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTubeListItem() {
    TubeListItem(
        tubeLineList = TubeLineList(
            created = "2022-01-01T00:00:00",
            id = "1",
            modeName = "Tube",
            modified = "2022-01-01T00:00:00",
            name = "Bakerloo"
        ),
        onItemClick = {}
    )
}
