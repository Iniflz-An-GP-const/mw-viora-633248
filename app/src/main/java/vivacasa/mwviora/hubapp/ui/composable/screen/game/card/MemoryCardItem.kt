package vivacasa.mwviora.hubapp.ui.composable.screen.game.card

import androidx.compose.ui.graphics.vector.ImageVector
import vivacasa.mwviora.hubapp.data.model.CardState

data class MemoryCardItem(
    val symbol: ImageVector,
    val state: CardState,
)
