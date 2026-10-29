package vivacasa.mwviora.hubapp.ui.composable.screen.main_menu.content.block

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuBlockItem(
    val title: String,
    val icon: ImageVector,
    val subtitle: String? = null,
    val emphasis: MenuBlockEmphasis = MenuBlockEmphasis.Neutral,
)
