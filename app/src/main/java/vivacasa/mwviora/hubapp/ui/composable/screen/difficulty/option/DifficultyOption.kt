package vivacasa.mwviora.hubapp.ui.composable.screen.difficulty.option

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vivacasa.mwviora.hubapp.ui.composable.screen.difficulty.option.content.DifficultyOptionContent
import vivacasa.mwviora.hubapp.ui.composable.screen.difficulty.option.meter.LevelMeter
import vivacasa.mwviora.hubapp.ui.composable.screen.difficulty.option.shell.DifficultyOptionShell

@Composable
fun DifficultyOption(
    item: DifficultyOptionItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DifficultyOptionShell(
        item = item,
        onClick = onClick,
        modifier = modifier,
    ) { shellItem ->
        DifficultyOptionContent(
            item = shellItem,
            meter = { LevelMeter(level = shellItem.level, levelCount = shellItem.levelCount) },
        )
    }
}
