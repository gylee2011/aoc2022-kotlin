package day02

enum class Outcome(val score: Int) {
    WIN(6),
    DRAW(3),
    LOSE(0);

    companion object {
        fun of(opponent: Shape, me: Shape): Outcome =
            when (opponent) {
                Shape.ROCK -> when (me) {
                    Shape.ROCK -> DRAW
                    Shape.PAPER -> WIN
                    Shape.SCISSOR -> LOSE
                }
                Shape.PAPER -> when (me) {
                    Shape.ROCK -> LOSE
                    Shape.PAPER -> DRAW
                    Shape.SCISSOR -> WIN
                }
                Shape.SCISSOR -> when (me) {
                    Shape.ROCK -> WIN
                    Shape.PAPER -> LOSE
                    Shape.SCISSOR -> DRAW
                }
            }
    }
}