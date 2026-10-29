package vivacasa.mwviora.hubapp.ui.composable.screen.difficulty

import vivacasa.mwviora.hubapp.R
import vivacasa.mwviora.hubapp.data.model.Difficulty

fun Difficulty.titleRes(): Int = when (this) {
    Difficulty.Easy -> R.string.difficulty_easy
    Difficulty.Medium -> R.string.difficulty_medium
    Difficulty.Hard -> R.string.difficulty_hard
}
