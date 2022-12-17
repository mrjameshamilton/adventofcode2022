

import eu.jameshamilton.adventofcode2022.day04.parseInput
import eu.jameshamilton.adventofcode2022.day04.part1
import eu.jameshamilton.adventofcode2022.day04.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppTest {
    private val input =
        object {}.javaClass.getResource("/input-example-part1.txt").readText()

    @Test
    fun testParseInput() {
        assertEquals(
            listOf(
                Pair(IntRange(2, 4), IntRange(6, 8)),
                Pair(IntRange(2, 3), IntRange(4, 5)),
                Pair(IntRange(5, 7), IntRange(7, 9)),
                Pair(IntRange(2, 8), IntRange(3, 7)),
                Pair(IntRange(6, 6), IntRange(4, 6)),
                Pair(IntRange(2, 6), IntRange(4, 8))
            ),
            parseInput(input)
        )
    }

    @Test
    fun testExamplePart1() {
        assertEquals(2, part1(parseInput(input)))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(4, part2(parseInput(input)))
    }
}
