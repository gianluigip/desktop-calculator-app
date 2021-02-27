package com.gianluigip.calculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OutputView(
    modifier: Modifier,
    formula: State<String>,
    currentValue: State<String>
) {

    Column(
        modifier.fillMaxWidth().background(MaterialTheme.colors.surface)
    ) {
        Row(
            Modifier.fillMaxWidth().weight(5f).padding(3.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(formula.value)
        }
        Row(
            Modifier.fillMaxWidth().weight(5f).padding(3.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(currentValue.value)
        }
    }
}