
import eu.jameshamilton.adventofcode2022.day02.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppTest {
    private val input =
        object {}.javaClass.getResource("/input-example-part1.txt").readText()

    @Test
    fun testExamplePart1() {
        assertEquals(15, part1(input))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(12, part2(input))
    }
}
