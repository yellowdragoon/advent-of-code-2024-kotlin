package day2

import java.io.File
import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    part1()
    part2()
}

fun part1() {
    val reports = parseInput("src/main/kotlin/day2/day2.txt")
    val totalSafe = reports.fold(0) {acc, ints ->  acc + (if (isReportSafe(ints)) 1 else 0)}
    println(totalSafe)
}

fun part2() {
    val reports = parseInput("src/main/kotlin/day2/day2.txt")
    var totalSafe = 0
    reports.map { report ->
        var safe = false
        for (i in 0..report.lastIndex) {
            if (isReportSafe(report.subList(0, i) + report.subList(i+1, report.lastIndex+1))) {
                safe = true
            }
        }
        if (isReportSafe(report)) {
            safe = true
        }
        totalSafe += if (safe) 1 else 0
    }
    println(totalSafe)
}

fun parseInput(filepath: String): List<MutableList<Int>> {
    val file = File(filepath)
    val reports = mutableListOf<MutableList<Int>>()
    file.readLines().forEach { it ->
        val items = it.split(" ").map { it.toInt() }.toMutableList()
        reports.add(items)
    }

    return reports
}

fun isReportSafe(report: List<Int>): Boolean {
    var isIncreasing: Boolean? = null
    var isSafe = true
    for (idx in 0..report.size-2) {
        val diff = report[idx] - report[idx + 1]
        if (diff == 0 || diff.absoluteValue > 3) {
            isSafe = false
        }
        else if (diff > 0) {
            if (isIncreasing == true) {
                isSafe = false
            }
            if (isIncreasing == null) {
                isIncreasing = false
            }
        }
        else {
            if (isIncreasing == false) {
                isSafe = false
            }
            if (isIncreasing == null) {
                isIncreasing = true
            }
        }
    }
    return isSafe
}