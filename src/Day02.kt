fun main() {
    /**
     * First: A for Rock, B for Paper, and C for Scissors
     * Second: X for Rock, Y for Paper, and Z for Scissors
     *
     * A beats Z
     * B beats X
     * C beats Y
     *
     */
    fun pointPerPair(pair: Pair<Char, Char>): Int {
        return when (pair.second) {
            'X' -> 1 +
                    when (pair.first) {
                        'A' -> 3
                        'B' -> 0
                        'C' -> 6
                        else -> throw IllegalArgumentException("Invalid input")
                    }

            'Y' -> 2 +
                    when (pair.first) {
                        'A' -> 6
                        'B' -> 3
                        'C' -> 0
                        else -> throw IllegalArgumentException("Invalid input")
                    }

            'Z' -> 3 +
                    when (pair.first) {
                        'A' -> 0
                        'B' -> 6
                        'C' -> 3
                        else -> throw IllegalArgumentException("Invalid input")
                    }

            else -> throw IllegalArgumentException("Invalid input")
        }
    }

    /**
     * X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
     */
    fun pointPerPairSecondRule(pair: Pair<Char, Char>): Int {
        return when (pair.second) {
            // X means you need to lose
            'X' -> 0 +
                    when (pair.first) {
                        'A' -> 3 // A beats Z
                        'B' -> 1 // B beats X
                        'C' -> 2 // C beats Y
                        else -> throw IllegalArgumentException("Invalid input")
                    }
            // Y means you need to end the round in a draw
            'Y' -> 3 +
                    when (pair.first) {
                        'A' -> 1
                        'B' -> 2
                        'C' -> 3
                        else -> throw IllegalArgumentException("Invalid input")
                    }
            // Z means you need to win.
            'Z' -> 6 +
                    when (pair.first) {
                        'A' -> 2
                        'B' -> 3
                        'C' -> 1
                        else -> throw IllegalArgumentException("Invalid input")
                    }

            else -> throw IllegalArgumentException("Invalid input")
        }
    }

    fun part1(input: List<Pair<Char, Char>>): Int {
        return input.fold(0) { acc, pair -> acc + pointPerPair(pair) }
    }

    fun part2(input: List<Pair<Char, Char>>): Int {
        return input.fold(0) { acc, pair -> acc + pointPerPairSecondRule(pair) }
    }


    val testInput = readInput("Day02_test")
    val parsedTestInput = testInput.map { it.split(" ") }.map { Pair(it[0].first(), it[1].first()) }
    check(part1(parsedTestInput) == 15)

    val input = readInput("Day02")
    val parsedInput = input.map { it.split(" ") }.map { Pair(it[0].first(), it[1].first()) }
    check(part1(parsedTestInput) == 15)
    check(part2(parsedTestInput) == 12)
    println(part1(parsedInput))
    println(part2(parsedInput))


}