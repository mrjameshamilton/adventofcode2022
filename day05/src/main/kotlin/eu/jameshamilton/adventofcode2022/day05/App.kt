package eu.jameshamilton.adventofcode2022.day05

import java.util.*


fun main() {
    val input = parseInput(object {}.javaClass.getResource("/input.txt").readText())
    println(part1(input.first, input.second))
    val input2 = parseInput(object {}.javaClass.getResource("/input.txt").readText())
    println(part2(input2.first, input2.second))
}

fun parseInput(string: String): Pair<Supplies, List<Move>> {
    val suppliesStrings = mutableListOf<String>()
    var numberOfStacks = 0
    val moves = mutableListOf<Move>()
    val lines = string.splitToSequence("\n")

    val regex = "^move (\\d+) from (\\d+) to (\\d+)$".toRegex()
    var endSupplies = false

    for (line in lines) {
        if (line.startsWith(" 1")) {
            endSupplies = true
            numberOfStacks = line.splitToSequence("\\s+".toRegex()).filterNot { it.isBlank() }.map { it.toInt() }.max()
            continue
        }

        if (line.isBlank()) continue

        if (!endSupplies) {
            suppliesStrings.add(line)

        } else {
            val (amount, from, to) = regex.matchEntire(line)!!.destructured
            moves.add(Move(amount.toInt(), from.toInt() - 1, to.toInt() - 1))
        }
    }

    val supplies = Supplies(numberOfStacks)

    for (line in suppliesStrings.reversed()) {
        for ((stack, i) in (1 .. line.length step 4).withIndex()) {
            val crate = line[i]
            if (!crate.isWhitespace()) supplies[stack].push(crate)
        }
    }

    return Pair(supplies, moves)
}

fun part1(supplies: Supplies, moves: List<Move>): String {
    moves.forEach { (amount, from, to) ->
        supplies[to].push(supplies[from].pop(amount))
    }
    return supplies.topEntriesAsString()
}

fun part2(supplies: Supplies, moves: List<Move>): String {
    moves.forEach { (amount, from, to) ->
        val collection = supplies[from].pop(amount).reversed()
        //println("move $collection from $from to $to")
        supplies[to].push(collection)
    }
    return supplies.topEntriesAsString()
}

typealias Crate = Char

data class Supplies(val numberOfStacks: Int) {
    val stacks = Array<Stack<Crate>>(numberOfStacks) {
        Stack()
    }
    operator fun get(i: Int) = stacks[i]

    override fun toString(): String = stacks.toList().toString()

    fun topEntriesAsString() = stacks.filterNot { it.empty() }.map { it.peek() }.joinToString(separator = "")
}

data class Move(val amount: Int, val from: Int, val to: Int)

fun <T> Stack<T>.pop(n: Int): List<T> = sequence {
    repeat(n) { yield(pop()) }
}.toList()

fun <T> Stack<T>.push(collection: Collection<T>) = collection.forEach { push(it) }
