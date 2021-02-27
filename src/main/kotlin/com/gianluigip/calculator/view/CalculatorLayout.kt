package com.gianluigip.calculator.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gianluigip.calculator.logic.Calculator

@Composable
fun CalculatorLayout() {
    Column(
        Modifier.fillMaxHeight().fillMaxHeight().padding(5.dp)
    ) {

        val calculator = remember { Calculator() }
        val formula: MutableState<String> = remember { mutableStateOf("") }
        val currentValue: MutableState<String> = remember { mutableStateOf("0") }

        OutputView(
            Modifier.weight(2f),
            formula,
            currentValue
        )
        Spacer(Modifier.size(2.dp))
        CalculatorKeyboard(
            Modifier.weight(8f),
            onNumberClick = { currentValue.value = calculator.insertNumber(it) },
            onOperationClick = {
                val partialResult = calculator.insertOperation(it)
                formula.value = partialResult.formula
                currentValue.value = partialResult.number2
            },
            onClear = {
                calculator.clear()
                formula.value = ""
                currentValue.value = "0"
            },
            onDelete = { currentValue.value = calculator.delete() },
            onResult = {
                val result = calculator.calculate()
                formula.value = result.formula
                currentValue.value = result.value.toString()
            }
        )

    }
}
