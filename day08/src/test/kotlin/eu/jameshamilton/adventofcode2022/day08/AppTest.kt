package eu.jameshamilton.adventofcode2022.day08

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
        val grid = parseInput(input)
        assertEquals(21, part1(grid))
    }

    @Test
    fun testExamplePart2() {
        val grid = parseInput(input)
        assertEquals(8, part2(grid))
    }
}
