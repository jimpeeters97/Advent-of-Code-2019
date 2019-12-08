package challenges

import java.io.File

fun main() {
    File("src/input/input_day4.txt").forEachLine {
        val range = it.split("-")
        val begin = range[0].toInt()
        val end = range[1].toInt()
        var counter = 0

        for(idx: Int in begin..end) {
            if(isValid(idx)) counter++
        }

        println("Valid passwords: $counter")
    }
}

fun isValid(password: Int) : Boolean {
    val list = password.toString().toMutableList().map { it.toInt() }
    var hasDouble = false

    for (idx: Int in 1 until list.size) {
        if(list[idx] < list[idx - 1]) return false

        if(list[idx] == list[idx - 1]) hasDouble = true
    }

    if(!hasDouble) {
        return false
    }

    return true
}