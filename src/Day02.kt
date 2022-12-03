import day02.*

fun main() {
    fun part1(input: List<String>): Int = input
        .map(String::toShapePair)
        .sumOf { (opponent, me) ->
            Outcome.of(opponent, me).score + me.score
        }

    fun part2(input: List<String>): Int = input
        .map {
            val (opponent, expectedOutcome) = it.split(" ")
            opponent.toShape() to expectedOutcome.toOutcome()
        }
        .sumOf { (opponent, expectedOutcome) ->
            val myShape = when (expectedOutcome) {
                Outcome.WIN -> opponent.winner
                Outcome.DRAW -> opponent
                Outcome.LOSE -> opponent.loser
            }

            myShape.score + expectedOutcome.score
        }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
