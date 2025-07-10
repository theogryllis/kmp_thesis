package org.theo.thesis

import androidx.compose.ui.window.ComposeUIViewController
import org.theo.thesis.ui.theme.KMPRedditTheme

fun MainViewController() = ComposeUIViewController {
    KMPRedditTheme {
        SettingsScreen()
    }
}