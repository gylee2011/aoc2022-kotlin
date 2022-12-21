import kotlin.math.max
import kotlin.math.min

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map {
                it.split(',')
            }
            .map { (elf1, elf2) ->
                val range1 = elf1.toRange()
                val range2 = elf2.toRange()

                val newStart = min(range1.first, range2.first)
                val newEnd = max(range1.last, range2.last)
                val newRange = newStart..newEnd

                (newRange == range1 || newRange == range2)
            }
            .count { it }
    }

    fun part2(input: List<String>): Int {
        return input
            .map {
                it.split(',')
            }
            .map { elves ->
                val sorted = elves.map { it.toRange() }.sortedBy { it.first }
                val (elf1, elf2) = sorted

                (elf1.last >= elf2.first)
            }
            .count { it }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

fun String.toRange(): IntRange = split('-')
    .let { (start, end) ->
        start.toInt()..end.toInt()
    }