fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0
        for (s in input) {
            if (s.isEmpty()) {
                max = current.coerceAtLeast(max)
                current = 0
                continue
            }
            current += s.toInt()
        }
        return max
    }

    fun part2(input: List<String>): Int {
        val caloriesPerElf = mutableListOf<Int>(0)
        for (s in input) {
            if (s.isEmpty()) {
                caloriesPerElf.add(0)
                continue
            }
            caloriesPerElf[caloriesPerElf.lastIndex] += s.toInt()
        }
        // sort list
        caloriesPerElf.sortDescending()

        return caloriesPerElf[0] + caloriesPerElf[1] + caloriesPerElf[2]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
