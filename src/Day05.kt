import java.util.*

/**
012345678901234567890
    [D]
[N] [C]
[Z] [M] [P]
1   2   3


1 + 4 * (n - 1)
 1: 1
 2: 5
 3: 9
 */
fun Int.times(block: () -> Unit) {
    for (i in 0 until this) {
        block()
    }
}

fun main() {
    fun readStackLine(line: String, stacks: List<Stack<Char>>) {
        var stackIndex = 0
        var position = 1

        while (position < line.lastIndex && stackIndex < stacks.count()) {
            val ch = line[position]

            if (ch == ' ') {
                stackIndex++
                position += 4
                continue
            }

            stacks[stackIndex].add(0, ch)
            stackIndex++
            position += 4
        }
    }

    fun move(count: Int, from: Stack<Char>, to: Stack<Char>) {
        for (i in 0 until count) {
            val c = from.pop()
            to.push(c)
        }
    }

    fun move2(count: Int, from: Stack<Char>, to: Stack<Char>) {
        val stack = Stack<Char>()

        count.times { stack.push(from.pop()) }

        count.times { to.push(stack.pop()) }
    }

    fun part1(input: String): String {
        val (cratesString, stepsString) = input.split("\n\n")

        val crates = cratesString.split('\n')

        val stackCountLine = crates.last()
        val stackCount = stackCountLine.last().digitToInt()
        val stacks = (0 until stackCount).map { Stack<Char>() }

        crates.subList(0, crates.count() - 1)
            .forEach { line ->
                readStackLine(line, stacks)
            }

        val steps = stepsString.split('\n')

        steps.forEach {
            val words = it.split(' ')
            val count = words[1].toInt()
            val from = words[3].toInt() - 1
            val to = words[5].toInt() - 1

            move(count, stacks[from], stacks[to])
        }

        return stacks.map { it.peek() }
            .joinToString("")
    }

    fun part2(input: String): String {
        val (cratesString, stepsString) = input.split("\n\n")

        val crates = cratesString.split('\n')

        val stackCountLine = crates.last()
        val stackCount = stackCountLine.last().digitToInt()
        val stacks = (0 until stackCount).map { Stack<Char>() }

        crates.subList(0, crates.count() - 1)
            .forEach { line ->
                readStackLine(line, stacks)
            }

        val steps = stepsString.split('\n')

        steps.forEach {
            val words = it.split(' ')
            val count = words[1].toInt()
            val from = words[3].toInt() - 1
            val to = words[5].toInt() - 1

            move2(count, stacks[from], stacks[to])
        }

        return stacks.map { it.peek() }
            .joinToString("")
    }

    val testInput = readInputText("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInputText("Day05")
    println(part1(input))
    println(part2(input))
}