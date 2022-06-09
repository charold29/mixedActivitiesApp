package upn.charold.mixed_activities_app.dice_roller.model

class Dice(private val numSides: Int){

    fun roll(): Int{
        return (1..numSides).random()
    }
}