package eu.jameshamilton.adventofcode2022.day06

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
        assertEquals(7, part1("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(5, part1("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, part1("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(19, part2("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, part2("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, part2("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}
