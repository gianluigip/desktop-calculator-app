package com.gianluigip.calculator.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun KeyField(number: String, modifier: Modifier = Modifier, onClick: (String) -> Unit = {}) {

    Box(
        modifier.clickable { onClick(number) },
        contentAlignment = Alignment.Center
    ) {
        Text(number)
    }

}
