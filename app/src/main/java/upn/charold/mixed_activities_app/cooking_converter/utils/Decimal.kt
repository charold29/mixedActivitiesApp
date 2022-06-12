package upn.charold.mixed_activities_app.cooking_converter.utils

import kotlin.math.round

class Decimal constructor(value: Double){

    private val number = value

    val decimales = numberAfterPoint()
    val parteEntera = numberBeforePoint()

    private fun toFraction(){
        TODO()
    }

    private fun numberAfterPoint(): Int {
        // If number has 1 or 2 decimals
        val decimal1 = (number * 10)
        val decimal2 = (number * 100)

        return when {
            decimal1 % 1 == 0.0 -> (decimal1 % 10).toInt()
            decimal2 % 1 == 0.0 -> (decimal2 % 100).toInt()
            else -> 0
        }

    }

    private fun numberBeforePoint(): Int {
        return number.toInt()
    }

}