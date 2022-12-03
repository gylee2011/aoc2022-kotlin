fun main() {
    fun part1(input: String): Int = input
        .split("\n\n")
        .maxOf { group ->
            group
                .split("\n")
                .sumOf { it.toInt() }
        }

    fun part2(input: String): Int = input
        .split("\n\n")
        .map { group ->
            group
                .split("\n")
                .sumOf { it.toInt() }
        }
        .take(3)
        .max()

    // test if implementation meets criteria from the description, like:
    val testInput = readInputText("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInputText("Day01")
    println(part1(input))
    println(part2(input))
}
