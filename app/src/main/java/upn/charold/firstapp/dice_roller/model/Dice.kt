package upn.charold.firstapp.dice_roller.model

class Dice(private val numSides: Int){

    fun roll(): Int{
        return (1..numSides).random()
    }
}