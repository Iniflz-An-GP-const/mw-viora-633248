package vivacasa.mwviora.hubapp.ui.composable.screen.main_menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import vivacasa.mwviora.hubapp.data.model.Difficulty
import vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.MainMenuContent
import vivacasa.mwviora.hubapp.ui.viewmodel.MenuViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VAVHPMainMenuScreen(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = koinViewModel(),
    onPlayClick: (Difficulty) -> Unit,
    onHighScoresScreenNavigation: () -> Unit,
    onAboutScreenNavigation: () -> Unit,
    onExit: () -> Unit,
) {
    val selectedDifficulty by viewModel.selectedDifficulty.collectAsState()
    val bestScores by viewModel.bestScores.collectAsState()

    MainMenuContent(
        modifier = modifier,
        selectedDifficulty = selectedDifficulty,
        bestScores = bestScores,
        onDifficultySelected = viewModel::selectDifficulty,
        onPlayClick = { onPlayClick(selectedDifficulty) },
        onHighScoresScreenNavigation = onHighScoresScreenNavigation,
        onAboutScreenNavigation = onAboutScreenNavigation,
        onExit = onExit,
    )
}
