package org.theo.thesis.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF0079D3),
    onPrimary = Color.White,
    background = Color(0xFF1a1a1b),
    onBackground = Color.White,
    surface = Color(0xFF1a1a1b),
    onSurface = Color.White,
    onSurfaceVariant = Color(0xFF9E9E9E)
)

@Composable
fun KMPRedditTheme(
    useDarkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography(),
        content = content
    )
}
