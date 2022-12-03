fun main() {
    fun characterPriority(char: Char) = if (char.code >= 97) char.code - 96 else char.code - 65 + 27

    fun part1(input: List<String>): Int {
        return input.fold(0) { acc, line ->
            val firstPart = line.slice(0 until line.length / 2)
            val secondPart = line.slice(line.length / 2 until line.length)
            val intersection = firstPart.toSet().intersect(secondPart.toSet())
            acc + intersection.fold(0) { acc2, char -> acc2 + (characterPriority(char)) }
        }
    }

    fun part2(input: List<String>): Int {
        // group 3 lines together
        return input.chunked(3).sumOf {
            val common = it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet())
            characterPriority(common.first())
        }
    }


    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))


}