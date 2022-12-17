
import eu.jameshamilton.adventofcode2022.day03.Rucksack
import eu.jameshamilton.adventofcode2022.day03.parseInput
import eu.jameshamilton.adventofcode2022.day03.part1
import eu.jameshamilton.adventofcode2022.day03.part2
import eu.jameshamilton.adventofcode2022.day03.priority
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppTest {
    private val input =
        object {}.javaClass.getResource("/input-example-part1.txt").readText()

    @Test
    fun testParseInput() {
        assertEquals(
            listOf(
                Rucksack("vJrwpWtwJgWr".toList(), "hcsFMMfFFhFp".toList()),
                Rucksack("jqHRNqRjqzjGDLGL".toList(), "rsFMfFZSrLrFZsSL".toList()),
                Rucksack("PmmdzqPrV".toList(), "vPwwTWBwg".toList()),
                Rucksack("wMqvLMZHhHMvwLH".toList(), "jbvcjnnSBnvTQFn".toList()),
                Rucksack("ttgJtRGJ".toList(), "QctTZtZT".toList()),
                Rucksack("CrZsJsPPZsGz".toList(), "wwsLwLmpwMDw".toList())
            ),
            parseInput(input)
        )
    }

    @Test
    fun testPriority() {
        assertEquals(27, 'A'.priority)
        assertEquals(1, 'a'.priority)
    }

    @Test
    fun testExamplePart1() {
        assertEquals(157, part1(parseInput(input)))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(70, part2(parseInput(input)))
    }
}
