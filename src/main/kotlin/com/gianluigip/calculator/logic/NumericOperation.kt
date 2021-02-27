package com.gianluigip.calculator.logic

enum class NumericOperation(val symbol: String) {

    ADD("+") {
        override fun calculate(number1: Double, number2: Double): Double {
            return number1 + number2
        }
    },
    SUBTRACT("-") {
        override fun calculate(number1: Double, number2: Double): Double {
            return number1 - number2
        }
    },
    MULTIPLY("*") {
        override fun calculate(number1: Double, number2: Double): Double {
            return number1 * number2
        }
    },
    DIVIDE("/") {
        override fun calculate(number1: Double, number2: Double): Double {
            return number1 / number2
        }
    };

    abstract fun calculate(number1: Double, number2: Double): Double
}