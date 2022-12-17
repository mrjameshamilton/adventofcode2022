import eu.jameshamilton.adventofcode2022.day05.Move
import eu.jameshamilton.adventofcode2022.day05.Supplies
import eu.jameshamilton.adventofcode2022.day05.parseInput
import eu.jameshamilton.adventofcode2022.day05.part1
import eu.jameshamilton.adventofcode2022.day05.part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppTest {
    private val input =
        object {}.javaClass.getResource("/input-example-part1.txt").readText()

    @Test
    fun testParseInput() {
        assertEquals(
            Pair(
                Supplies(3).apply {
                    stacks[0].add('Z')
                    stacks[0].add('N')

                    stacks[1].add('M')
                    stacks[1].add('C')
                    stacks[1].add('D')

                    stacks[2].add('P')
                },
                listOf(
                    Move(1, 2, 1),
                    Move(3, 1, 3),
                    Move(2, 2, 1),
                    Move(1, 1, 2)
                )
            ),
            parseInput(input)
        )
    }

    @Test
    fun testExamplePart1() {
        val suppliesListPair = parseInput(input)
        assertEquals("CMZ", part1(suppliesListPair.first, suppliesListPair.second))
    }

    @Test
    fun testExamplePart2() {
        val suppliesListPair = parseInput(input)
        assertEquals("MCD", part2(suppliesListPair.first, suppliesListPair.second))
    }
}
