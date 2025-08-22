package org.example.day1

import java.io.File
import kotlin.math.abs

fun main() {
    part1()
    part2()
}

fun part1() {
    val (firstList, secondList) = parseInput("src/main/kotlin/day1/day1.txt")
    firstList.sort()
    secondList.sort()

    var absSum = 0

    firstList.mapIndexed { index, i ->
        absSum += abs(i - secondList[index])
    }

    println(absSum)
}

fun part2() {
    val (firstList, secondList) = parseInput("src/main/kotlin/day1/day1.txt")
    val frequencyMap = mutableMapOf<Int, Int>().withDefault { 0 }

    for (i in secondList) {
        frequencyMap[i] = frequencyMap.getValue(i) + 1
    }

    val similarity = firstList.fold(0) { acc, i -> acc + frequencyMap.getValue(i) * i }

    println(similarity)
}

fun parseInput(filepath: String): Pair<MutableList<Int>, MutableList<Int>> {
    val file = File(filepath)
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()
    file.readLines().forEach { it ->
        val items = it.split("   ")
        firstList += items[0].toInt()
        secondList += items[1].toInt()
    }

    return Pair(firstList, secondList)
}