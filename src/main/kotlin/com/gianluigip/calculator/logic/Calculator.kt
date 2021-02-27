package com.gianluigip.calculator.logic

class Calculator {

    var number1 = "0"
    var number2 = "0"
    var operation: NumericOperation? = null

    fun insertNumber(numericOption: NumericOption): String {
        return if (operation == null) {
            number1 = processNumericOption(number1, numericOption)
            number1
        } else {
            number2 = processNumericOption(number2, numericOption)
            number2
        }
    }

    private fun processNumericOption(number: String, numericOption: NumericOption): String {
        return when (numericOption) {
            NumericOption.NEGATE -> {
                if (number == "0") {
                    number
                } else if (number.startsWith("-")) {
                    number.substring(1)
                } else {
                    "-$number"
                }
            }
            NumericOption.DOT -> {
                if (number.contains(".")) {
                    number
                } else {
                    "$number."
                }
            }
            else -> {
                if (number == "0") {
                    numericOption.numericValue!!.toString()
                } else {
                    "$number${numericOption.numericValue!!}"
                }
            }
        }
    }

    fun insertOperation(operation: NumericOperation): PartialResult {
        this.operation = operation
        return PartialResult(number1, number2, "$number1 ${operation.symbol}")
    }

    fun delete(): String {
        return if (operation == null) {
            number1 = deleteLastNumber(number1)
            number1
        } else {
            number2 = deleteLastNumber(number2)
            number2
        }
    }

    private fun deleteLastNumber(number: String): String {
        return when {
            number == "0" -> number
            number.length == 1 -> "0"
            number.length == 2 && number.startsWith("-") -> "0"
            else -> number.substring(0, number.length - 1)
        }
    }

    fun clear() {
        number1 = "0"
        number2 = "0"
        operation = null
    }

    fun calculate(): CalculatorResult {

        val numericValue1 = number1.toDouble()
        val numericValue2 = number2.toDouble()

        if (operation == null) {
            return CalculatorResult(numericValue1, "$number1 =")
        }

        val result = operation!!.calculate(numericValue1, numericValue2)
        val formula = "$number1 ${operation!!.symbol} $number2"

        number1 = result.toString()
        number2 = "0"
        operation = null
        return CalculatorResult(result, formula)
    }
}
