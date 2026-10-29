package vivacasa.mwviora.hubapp.ui.composable.screen.high_scores.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import vivacasa.mwviora.hubapp.R
import vivacasa.mwviora.hubapp.ui.composable.screen.high_scores.card.HighScoreCardDefaults
import vivacasa.mwviora.hubapp.ui.composable.screen.high_scores.card.HighScoreCardItem
import vivacasa.mwviora.hubapp.ui.theme.cardBorderStroke

@Composable
fun HighScoreCard(
    item: HighScoreCardItem,
    modifier: Modifier = Modifier,
) {
    val shape = HighScoreCardDefaults.shape
    val border = cardBorderStroke()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(color = MaterialTheme.colorScheme.surfaceContainer, shape = shape)
            .let { base -> if (border != null) base.border(border, shape) else base }
            .padding(HighScoreCardDefaults.padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(
                R.string.high_score_card_score_format,
                item.moves,
                item.formattedTime
            ),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = item.formattedDate,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
