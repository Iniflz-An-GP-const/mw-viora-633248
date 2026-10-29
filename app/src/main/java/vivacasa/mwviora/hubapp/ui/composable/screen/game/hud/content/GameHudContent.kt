package vivacasa.mwviora.hubapp.ui.composable.screen.game.hud.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import vivacasa.mwviora.hubapp.R
import vivacasa.mwviora.hubapp.ui.composable.screen.game.hud.GameHudDefaults
import vivacasa.mwviora.hubapp.ui.composable.screen.game.hud.GameHudItem
import vivacasa.mwviora.hubapp.ui.theme.LocalDimens

@Composable
fun GameHudContent(
    item: GameHudItem,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing),
    ) {
        Text(
            text = item.elapsedText,
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(R.string.game_moves_format, item.moves),
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = GameHudDefaults.pairsText(item),
                style = MaterialTheme.typography.titleMedium,
            )
        }

        Text(
            text = GameHudDefaults.phaseText(item),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
        )
        Text(
            text = GameHudDefaults.bestText(item),
            color = GameHudDefaults.secondaryColor(),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
    }
}
