package challenges

import java.io.File
import kotlin.math.abs

fun main() {
    val cableList = arrayListOf<List<Pair<Int, Int>>>()

    File("src/input/input_day3.txt").forEachLine {
        val cable = arrayListOf<Pair<Int, Int>>()

        var currentX = 0
        var currentY = 0

        val directionList = it.split(",")

        directionList.forEach { dir ->
            val dirIdx = dir.substring(1).toInt()
            for (idx: Int in 0 until dirIdx) {
                when {
                    dir.startsWith("L") -> {
                        currentX -= 1
                        cable.add(Pair(currentX, currentY))
                    }
                    dir.startsWith("R") -> {
                        currentX += 1
                        cable.add(Pair(currentX, currentY))
                    }
                    dir.startsWith("D") -> {
                        currentY -= 1
                        cable.add(Pair(currentX, currentY))
                    }
                    else -> {
                        currentY += 1
                        cable.add(Pair(currentX, currentY))
                    }
                }
            }
        }
        cableList.add(cable)
    }
    println("The closest distance is: " + findClosestDistance(cableList))
}

fun findClosestDistance(cableList: List<List<Pair<Int, Int>>>): Int {
    val intersections = arrayListOf<Pair<Int, Int>>()
    var closestDistance = 9999999

    if (cableList.isNotEmpty()) {
        val firstCable = cableList[0]

        for (cablePoint: Pair<Int, Int> in firstCable) {
            var containsPoint = true
            for (cable: List<Pair<Int, Int>> in cableList.subList(1, cableList.size)) {
                if (!cable.contains(cablePoint)) {
                    containsPoint = false
                    break
                }
            }

            if (containsPoint) {
                intersections.add(cablePoint)
            }
        }
    }

    intersections.forEach {
        //for the first exercise
        val distance = abs(it.first) + abs(it.second)
        if (distance < closestDistance) {
            closestDistance = distance
        }
    }

    return closestDistance
}