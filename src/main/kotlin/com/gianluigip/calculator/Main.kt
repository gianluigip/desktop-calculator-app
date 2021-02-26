package com.gianluigip.calculator

import androidx.compose.desktop.Window
import androidx.compose.material.Text
import androidx.compose.ui.unit.IntSize

fun main() = Window(
    title = "Calculator",
    size = IntSize(500, 500)
) {
    Text("Hello, World!")
}