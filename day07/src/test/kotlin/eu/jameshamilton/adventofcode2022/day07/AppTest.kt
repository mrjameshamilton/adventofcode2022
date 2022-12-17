package eu.jameshamilton.adventofcode2022.day07

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AppTest {
    private val input =
        object {}.javaClass.getResource("/input-example-part1.txt").readText()

    @Test
    fun testParseInput() {

    }

    @Test
    fun testExamplePart1() {
        assertEquals(95437, part1(parseInput(input), 100000))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(24933642, part2(parseInput(input)))
    }
}
