package day02

fun String.toShape() = Shape.values().first { it.encryptedOpponent == this }

fun String.toMyShape() = Shape.values().first { it.encryptedResponse == this }

fun String.toShapePair() = split(" ").let { it[0].toShape() to it[1].toMyShape() }

fun String.toOutcome() = when (this) {
    "X" -> Outcome.LOSE
    "Y" -> Outcome.DRAW
    "Z" -> Outcome.WIN
    else -> throw IllegalArgumentException()
}