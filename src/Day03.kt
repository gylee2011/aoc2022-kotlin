fun main() {
    fun part1(input: List<String>): Int = input
        .map { it.chunked(it.length / 2) }
        .map { it[0].toSet() to it[1].toSet() }
        .map { (first, second) -> first.intersect(second).first() }
        .sumOf { it.priority }

    fun part2(input: List<String>): Int = input
        .chunked(3)
        .map { commonCharOf(it) }
        .sumOf { it.priority }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

val Char.priority: Int
    get() = if (isLowerCase()) {
        (this.code - 'a'.code + 1)
    } else {
        (this.code - 'A'.code + 27)
    }

fun commonCharOf(list: List<String>): Char {
    return list.map { it.toSet().toMutableSet() }
        .reduce { acc, set -> acc.apply { retainAll(set) } }
        .first()
}