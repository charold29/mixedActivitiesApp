package upn.charold.mixed_activities_app.cooking_converter.utils

import kotlin.math.round

class Decimal constructor(value: Double){

    private val number = value

    val fraction = onlyFraction()
    val parteEntera = numberBeforePoint()

    private fun toFraction(){
        TODO()
    }

    private fun numberAfterPoint(): Double {
        // If number has 1 or 2 decimals
        val decimal1 = (number * 10)
        val decimal2 = (number * 100)

        return when {
            decimal1 % 1 == 0.0 -> ((decimal1 % 10)/10)
            decimal2 % 1 == 0.0 -> ((decimal2 % 100)/100)
            else -> 0.0
        }

    }

    private fun numberBeforePoint(): Int {
        return number.toInt()
    }

    private fun onlyFraction(): String{

        return when (numberAfterPoint()) {
            in 0.0..0.15 ->  ""
            in 0.15..0.3 ->  "1/4"
            in 0.3..0.45 ->  "1/3"
            in 0.45..0.6 ->  "1/2"
            in 0.6..0.75 ->  "2/3"
            in 0.75..0.9 ->  "3/4"
            in 0.9..0.99 ->  "+1"
            else -> ""
        }

    }
}

