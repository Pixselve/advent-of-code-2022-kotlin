class SectionRange(range: String) {
    private val start: Int
    private val end: Int

    init {
        val split = range.split("-")
        this.start = split[0].toInt()
        this.end = split[1].toInt()
    }

    fun contains(value: SectionRange): Boolean {
        return value.start >= start && value.end <= end
    }

    fun overlaps(value: SectionRange): Boolean {
        return value.start <= end && value.end >= start
    }

    override fun toString(): String {
        return "SectionRange(start=$start, end=$end)"
    }
}

fun parseSectionRanges(input: List<String>): List<Pair<SectionRange, SectionRange>> {
    return input.map {
        val (firstPart, secondPart) = it.split(",")
        val first = SectionRange(firstPart)
        val second = SectionRange(secondPart)
        first to second
    }
}


fun main() {


    fun part1(input: List<Pair<SectionRange, SectionRange>>): Int {
        return input.map { it.first.contains(it.second) || it.second.contains(it.first) }.count { it }
    }

    fun part2(input: List<Pair<SectionRange, SectionRange>>): Int {
        return input.map { it.first.overlaps(it.second) || it.second.overlaps(it.first) }.count { it }
    }


    val testInput = readInput("Day04_test")
    val parsedTestInput = parseSectionRanges(testInput)

    check(part1(parsedTestInput) == 2)
    check(part2(parsedTestInput) == 4)

    val input = readInput("Day04")
    val parsedInput = parseSectionRanges(input)
    println(part1(parsedInput))
    println(part2(parsedInput))


}