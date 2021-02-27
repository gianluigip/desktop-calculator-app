package com.gianluigip.calculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gianluigip.calculator.logic.NumericOption
import com.gianluigip.calculator.logic.NumericOperation

@Composable
fun CalculatorKeyboard(
    modifier: Modifier,
    onNumberClick: (NumericOption) -> Unit = {},
    onOperationClick: (NumericOperation) -> Unit = {},
    onClear: () -> Unit = {},
    onDelete: () -> Unit = {},
    onResult: () -> Unit = {},
) {

    Column(
        modifier.fillMaxWidth()
    ) {

        val defaultBackground = MaterialTheme.colors.surface
        fun keyModifier(weight: Float = 1f, background: Color = defaultBackground): Modifier {
            return Modifier.weight(weight).fillMaxHeight()
                .padding(1.dp)
                .background(background)
        }


        Row(Modifier.fillMaxWidth().weight(1f)) {
            KeyField("Clear", keyModifier(background = MaterialTheme.colors.secondary)) { onClear() }
            KeyField("Delete", keyModifier(background = MaterialTheme.colors.secondary)) { onDelete() }
            KeyField("Results", keyModifier(2f, background = MaterialTheme.colors.primary)) { onResult() }
        }

        Row(Modifier.fillMaxWidth().weight(1f)) {
            KeyField("7", keyModifier()) { onNumberClick(NumericOption.SEVEN) }
            KeyField("8", keyModifier()) { onNumberClick(NumericOption.EIGHT) }
            KeyField("9", keyModifier()) { onNumberClick(NumericOption.NINE) }
            KeyField("/", keyModifier()) { onOperationClick(NumericOperation.DIVIDE) }
        }

        Row(Modifier.fillMaxWidth().weight(1f)) {
            KeyField("4", keyModifier()) { onNumberClick(NumericOption.FOUR) }
            KeyField("5", keyModifier()) { onNumberClick(NumericOption.FIVE) }
            KeyField("6", keyModifier()) { onNumberClick(NumericOption.SIX) }
            KeyField("*", keyModifier()) { onOperationClick(NumericOperation.MULTIPLY) }
        }

        Row(Modifier.fillMaxWidth().weight(1f)) {
            KeyField("1", keyModifier()) { onNumberClick(NumericOption.ONE) }
            KeyField("2", keyModifier()) { onNumberClick(NumericOption.TWO) }
            KeyField("3", keyModifier()) { onNumberClick(NumericOption.THREE) }
            KeyField("-", keyModifier()) { onOperationClick(NumericOperation.SUBTRACT) }
        }

        Row(Modifier.fillMaxWidth().weight(1f)) {
            KeyField("+/-", keyModifier()) { onNumberClick(NumericOption.NEGATE) }
            KeyField("0", keyModifier()) { onNumberClick(NumericOption.ZERO) }
            KeyField(".", keyModifier()) { onNumberClick(NumericOption.DOT) }
            KeyField("+", keyModifier()) { onOperationClick(NumericOperation.ADD) }
        }
    }

}
