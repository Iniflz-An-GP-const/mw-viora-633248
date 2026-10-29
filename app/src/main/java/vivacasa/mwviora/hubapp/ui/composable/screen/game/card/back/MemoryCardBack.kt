package vivacasa.mwviora.hubapp.ui.composable.screen.game.card.back

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vivacasa.mwviora.hubapp.ui.composable.screen.game.card.MemoryCardDefaults

private const val PatternColumns = 3
private const val PatternRows = 4
private const val PatternAlpha = 0.3f
private const val PatternIconFraction = 0.55f

@Composable
fun MemoryCardBack(modifier: Modifier = Modifier) {
    val tint = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = PatternAlpha)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MemoryCardDefaults.shape
            )
            .padding(4.dp),
    ) {
        repeat(PatternRows) {
            Row(modifier = Modifier.weight(1f)) {
                repeat(PatternColumns) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Diamond,
                            contentDescription = null,
                            tint = tint,
                            modifier = Modifier.fillMaxSize(PatternIconFraction),
                        )
                    }
                }
            }
        }
    }
}
