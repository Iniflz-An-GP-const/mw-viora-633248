package vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.difficulty

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import vivacasa.mwviora.hubapp.R
import vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.block.MenuBlockDefaults
import vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.block.menuBlockSurface
import vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.difficulty.DifficultyBlockItem
import vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.difficulty.DifficultyBlockLevel
import vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.difficulty.DifficultyFieldPreview
import vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.difficulty.difficultyFieldPreviewHeight
import vivacasa.mwviora.hubapp.ui.theme.LocalDimens

@Composable
fun DifficultyBlock(
    item: DifficultyBlockItem,
    onSelect: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(
        modifier = modifier.menuBlockSurface(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
    ) {
        Text(
            text = item.title,
            color = MenuBlockDefaults.contentColor,
            style = MaterialTheme.typography.titleMedium,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ArrowButton(
                isEnabled = item.selectedIndex > 0,
                isNext = false,
                onClick = { onSelect(item.selectedIndex - 1) },
            )

            AnimatedContent(
                targetState = item.selectedIndex,
                modifier = Modifier.weight(1f),
                transitionSpec = {
                    val direction = if (targetState > initialState) 1 else -1
                    (slideInHorizontally { width -> width * direction / 2 } + fadeIn()) togetherWith
                            (slideOutHorizontally { width -> -width * direction / 2 } + fadeOut())
                },
                label = "difficultyLevel",
            ) { index ->
                LevelContent(level = item.levels[index], maxRows = item.maxRows)
            }

            ArrowButton(
                isEnabled = item.selectedIndex < item.levels.lastIndex,
                isNext = true,
                onClick = { onSelect(item.selectedIndex + 1) },
            )
        }
    }
}

@Composable
private fun LevelContent(level: DifficultyBlockLevel, maxRows: Int) {
    val dimens = LocalDimens.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing),
    ) {
        Box(
            modifier = Modifier.height(difficultyFieldPreviewHeight(maxRows)),
            contentAlignment = Alignment.Center,
        ) {
            DifficultyFieldPreview(rows = level.rows, columns = level.columns)
        }
        Text(
            text = level.title,
            color = MenuBlockDefaults.contentColor,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
        )
        Text(
            text = level.subtitle,
            color = MenuBlockDefaults.secondaryContentColor,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun ArrowButton(
    isEnabled: Boolean,
    isNext: Boolean,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick, enabled = isEnabled) {
        Icon(
            imageVector = if (isNext) {
                Icons.AutoMirrored.Filled.KeyboardArrowRight
            } else {
                Icons.AutoMirrored.Filled.KeyboardArrowLeft
            },
            contentDescription = stringResource(
                if (isNext) R.string.menu_next_difficulty else R.string.menu_previous_difficulty,
            ),
        )
    }
}
