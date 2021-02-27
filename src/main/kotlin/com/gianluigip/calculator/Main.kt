package com.gianluigip.calculator

import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.IntSize
import com.gianluigip.calculator.view.CalculatorLayout
import com.gianluigip.calculator.view.lightTheme

fun main() = Window(
    title = "Calculator",
    size = IntSize(400, 500)
) {
    MaterialTheme(colors = lightTheme) {
        CalculatorLayout()
    }
}
