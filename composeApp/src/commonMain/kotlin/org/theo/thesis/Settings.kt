package org.theo.thesis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.adamglin.phosphoricons.BoldGroup
import com.adamglin.phosphoricons.RegularGroup
import com.adamglin.phosphoricons.DuotoneGroup
import com.adamglin.phosphoricons.FillGroup
import com.adamglin.phosphoricons.LightGroup
import com.adamglin.phosphoricons.ThinGroup
import com.adamglin.phosphoricons.bold.ArrowLeft
import com.adamglin.phosphoricons.regular.ArrowsClockwise
import com.adamglin.phosphoricons.regular.CaretRight
import com.adamglin.phosphoricons.regular.FilmStrip
import com.adamglin.phosphoricons.regular.Globe
import com.adamglin.phosphoricons.regular.GridFour
import com.adamglin.phosphoricons.regular.Image
import com.adamglin.phosphoricons.regular.Smiley
import com.adamglin.phosphoricons.regular.Star
import com.adamglin.phosphoricons.regular.TextAa
import com.adamglin.phosphoricons.regular.Translate
import com.adamglin.phosphoricons.regular.User
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var isAdult by remember { mutableStateOf(true) }
    var blur18 by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Einstellungen") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = BoldGroup.ArrowLeft,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            item {
                settingsSection("ALLGEMEINES") {
                    settingsItem(
                        icon = RegularGroup.User,
                        title = "Kontoeinstellungen für u/dave_the_goliath"
                    )
                }
            }

            item {
                settingsSection("PREMIUM") {
                    settingsItem(icon = RegularGroup.Star, title = "Hol dir Premium")
                    settingsItem(icon = RegularGroup.ArrowsClockwise, title = "App-Symbol ändern")
                    settingsItem(icon = RegularGroup.Smiley, title = "Avatar erstellen")
                }
            }

            item {
                settingsSection("SPRACHE") {
                    settingsItem(icon = RegularGroup.Globe, title = "Sprache") {
                        Text(
                            "Gerätesprache verwenden",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    settingsItem(icon = RegularGroup.Translate, title = "Inhaltssprachen") {
                        Icon(
                            imageVector = RegularGroup.CaretRight,
                            contentDescription = null
                        )
                    }
                }
            }

            item {
                settingsSection("ANZEIGEOPTIONEN") {
                    settingsItem(icon = RegularGroup.GridFour, title = "Standardansicht") {
                        Text(
                            "Karte",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    settingsItem(icon = RegularGroup.Image, title = "Vorschaubilder") {
                        Text(
                            "Community-Standard",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    switchItem(
                        title = "Nicht jugendfreie Inhalte anzeigen (ich bin über 18)",
                        value = isAdult
                    ) { isAdult = it }
                    switchItem(
                        title = "„18+“-Inhalte und -Medien verwischen",
                        value = blur18
                    ) { blur18 = it }
                }
            }

            item {
                settingsSection("BARRIEREFREIHEIT") {
                    settingsItem(icon = RegularGroup.TextAa, title = "Textgröße erhöhen")
                    settingsItem(icon = RegularGroup.FilmStrip, title = "Medien und Animationen")
                }
            }
        }
    }
}

@Composable
fun settingsSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        content()
    }
}

@Composable
fun settingsItem(
    icon: ImageVector,
    title: String,
    trailing: @Composable (() -> Unit)? = {
        Icon(
            imageVector = RegularGroup.CaretRight,
            contentDescription = null
        )
    }
) {
    ListItem(
        headlineContent = { Text(title) },
        leadingContent = { Icon(icon, contentDescription = null) },
        trailingContent = trailing,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}

@Composable
fun switchItem(
    title: String,
    value: Boolean,
    onToggle: (Boolean) -> Unit
) {
    ListItem(
        headlineContent = { Text(title) },
        trailingContent = {
            Switch(
                checked = value,
                onCheckedChange = onToggle,
                modifier = Modifier
                    .height(12.dp)
                    .width(44.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF0079D3)
                )
            )
        },
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}
