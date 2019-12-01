package challenges

import java.io.File
import kotlin.math.floor

fun main() {
    var counter = 0

    File("src/input/input_day1.txt").forEachLine {


        val mass = it.toDouble()
        var fuelMass = floor(mass / 3).toInt()  - 2

        while(fuelMass > 0) {
            counter += fuelMass
            fuelMass = floor(fuelMass.toDouble() / 3).toInt()  - 2
        }
    }

    println("The fuel requirements are:$counter")
}