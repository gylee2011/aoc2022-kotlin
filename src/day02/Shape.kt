package day02

enum class Shape(val encryptedOpponent: String, val encryptedResponse: String, val score: Int) {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSOR("C", "Z", 3);

    val loser: Shape get() =
        when (this) {
            ROCK -> SCISSOR
            PAPER -> ROCK
            SCISSOR -> PAPER
        }

    val winner: Shape get() =
        when (this) {
            ROCK -> PAPER
            PAPER -> SCISSOR
            SCISSOR -> ROCK
        }
}