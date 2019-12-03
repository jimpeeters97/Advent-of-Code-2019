package challenges

import java.io.File

fun main() {
    var originalList: MutableList<Int>
    var inputList = emptyList<Int>().toMutableList()

    File("src/input/input_day2.txt").forEachLine { line ->
        originalList = line.split(",").map { it.toInt() } as MutableList<Int>
        var found = false

        while (!found) {

            for (x in 0..99) {
                for (y in 0..99) {
                    inputList = arrayListOf()
                    inputList.addAll(originalList)

                    inputList[1] = x
                    inputList[2] = y

                    var firstIdx = 0
                    var opOneIdx = 1
                    var opTwoIdx = 2
                    var opThreeIdx = 3

                    while (inputList[firstIdx] != 99) {
                        val opOneValue = inputList[inputList[opOneIdx]]
                        val opTwoValue = inputList[inputList[opTwoIdx]]

                        if (inputList[firstIdx] == 1) {
                            val newValue = opOneValue + opTwoValue

                            inputList[inputList[opThreeIdx]] = newValue
                        } else if (inputList[firstIdx] == 2) {
                            val newValue = Math.multiplyExact(opOneValue, opTwoValue)

                            inputList[inputList[opThreeIdx]] = newValue
                        }

                        firstIdx += 4
                        opOneIdx = firstIdx + 1
                        opTwoIdx = opOneIdx + 1
                        opThreeIdx = opTwoIdx + 1
                    }

                    if (inputList[0] == 19690720) {
                        println("Value at position 1 is: " + inputList[1])
                        println("Value at position 2 is: " + inputList[2])

                        println((100 * inputList[1]) + inputList[2])

                        found = true
                    }
                }
            }


        }
    }

    println("Value at position 0 is: " + inputList[0])
}