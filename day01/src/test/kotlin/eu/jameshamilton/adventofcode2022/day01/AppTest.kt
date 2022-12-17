package eu.jameshamilton.adventofcode2022.day01

import eu.jameshamilton.adventofcode2022.utilities.Elf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppTest {
    private val part1ExampleInput = parseInput(
        object {}.javaClass.getResource("/input-example-part1.txt").readText()
    )

    @Test
    fun testInput() {
        assertEquals(
            listOf(
                Elf(6000),
                Elf(4000),
                Elf(11_000),
                Elf(24_000),
                Elf(10_000)
            ),
            part1ExampleInput
        )
    }

    @Test
    fun testExamplePart1() {
        assertEquals(24_000, part1(part1ExampleInput))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(45_000, part2(part1ExampleInput))
    }
}
