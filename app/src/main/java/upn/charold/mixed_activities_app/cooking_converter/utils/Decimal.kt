package upn.charold.mixed_activities_app.cooking_converter.utils

class Decimal constructor(value: Double){

    private val number = value

    private val fractionPart = fractionAfterPoint()
    private val integerPart = numberBeforePoint()

    /*
    Returns the integer part of a double number without round it
     */
    private fun numberBeforePoint(): Int {
        return number.toInt()
    }

    /*
    This function return the decimal part of a double number
     */
    private fun decimalAfterPoint(): Double {
        // decimal1: if number has just one digit
        val decimal1 = (number * 10)
        // decimal2: if number has 2 digits
        val decimal2 = (number * 100)

        return when {
            decimal1 % 1 == 0.0 -> ((decimal1 % 10)/10)
            decimal2 % 1 == 0.0 -> ((decimal2 % 100)/100)
            else -> 0.0
        }

    }

    /*
    This function return the decimal part converted to fraction of a double number.
     */
    private fun fractionAfterPoint(): String{

        return when (decimalAfterPoint()) {
            in 0.0..0.2 ->  ""
            in 0.2..0.3 ->  "1/4"
            in 0.3..0.45 ->  "1/3"
            in 0.45..0.6 ->  "1/2"
            in 0.6..0.75 ->  "2/3"
            in 0.75..0.9 ->  "3/4"
            in 0.9..0.99 ->  "1"
            else -> ""
        }

    }

    fun vulgarFraction(): String {
        // if integer part of the number is 0 : just return the fraction part
        val fractionResult: String = if (integerPart == 0){
            if (fractionPart == ""){
                " or 0 "
            }else
                " or $fractionPart "
        }else{
            when (fractionPart) {
                "" -> {
                    " or $integerPart "
                }
                // if the fraction part returned in the range of 0.9 - 0.99 : return integer part + 1
                "1" -> {
                    " or ${integerPart+1} "
                    // else return the full fraction (integer part and fraction part)
                }
                else -> {
                    " or $integerPart "
                        .plus(fractionPart)
                        .plus(" ")
                }
            }
        }

        return fractionResult

    }
}

