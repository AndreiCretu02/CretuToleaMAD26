package com.example.helloworld.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// --- DARK MODE: Black Background, Yellow Text ---
private val DarkColorScheme = darkColorScheme(
    primary = MainRed,               // Buttons are Red
    onPrimary = DeepBlack,           // Text on buttons is Black

    background = DeepBlack,          // Screen background is Black
    onBackground = PastelYellow,     // Main text is Pastel Yellow

    surface = DeepBlack,             // Cards/Lists are Black
    onSurface = PastelYellow         // Text on cards is Pastel Yellow
)

// --- LIGHT MODE: White Background, Black Text ---
private val LightColorScheme = lightColorScheme(
    primary = MainRed,               // Buttons stay Red
    onPrimary = PureWhite,           // Text on buttons is White (for contrast)

    background = PureWhite,          // Screen background swaps to White
    onBackground = DeepBlack,        // Main text swaps to Black (Yellow is too hard to read on White)

    surface = PureWhite,
    onSurface = DeepBlack
)

@Composable
fun HelloWorldTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // SET TO FALSE to force your colors!
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}