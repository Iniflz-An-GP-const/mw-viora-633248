package vivacasa.mwviora.hubapp.ui.composable.screen.difficulty.option.meter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import vivacasa.mwviora.hubapp.ui.composable.screen.difficulty.option.DifficultyOptionDefaults

private val StarSize = 32.dp

@Composable
fun LevelMeter(
    level: Int,
    levelCount: Int,
    modifier: Modifier = Modifier,
) {
    val color = LocalContentColor.current

    Box(modifier = modifier.size(StarSize)) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = color.copy(alpha = DifficultyOptionDefaults.INACTIVE_ALPHA),
            modifier = Modifier.size(StarSize),
        )
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .size(StarSize)
                .clip(LeftFractionShape(level.toFloat() / levelCount)),
        )
    }
}

/** Keeps only the left [fraction] of the element. */
private class LeftFractionShape(private val fraction: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline =
        Outline.Rectangle(
            Rect(
                left = 0f,
                top = 0f,
                right = size.width * fraction,
                bottom = size.height
            )
        )
}
