package day3

import java.io.File
import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    part1()
    part2()
}

fun part1() {
    val lines = parseInput("src/main/kotlin/day3/day3.txt")
    val regex = Regex("""mul\((\d+),(\d+)\)""")
    var sum = 0
    lines.forEach { line ->
        regex.findAll(line).forEach { matchResult ->
            val a = matchResult.groupValues[1].toInt()
            val b = matchResult.groupValues[2].toInt()
            sum += (a * b)
        }
    }
    println(sum)
}

fun part2() {
    val lines = parseInput("src/main/kotlin/day3/day3.txt")
    val regex = Regex("""mul\((\d+),(\d+)\)""")
}

fun parseInput(filepath: String): List<String> {
    val file = File(filepath)
    val lines = file.readLines()
    return lines
}
