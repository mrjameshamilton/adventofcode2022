package eu.jameshamilton.adventofcode2022.day07

import java.util.function.Predicate


fun main() {
    val input = parseInput(object {}.javaClass.getResource("/input.txt").readText())
    println(part1(input, 100000))
    println(part2(input))
}

fun parseInput(input: String): Directory {
    val root = Directory("/")
    var pwd: Directory = root

    input.split("\n").forEach { line ->
        when {
            line.startsWith("$") -> {
                val command = line.substring(2).substringBefore(" ")
                val parameter = line.substring(2).substringAfter(" ", "")
                println("$ $command $parameter")
                when (command) {
                    "cd" -> pwd = if (parameter == "/") root else pwd.cd(parameter)

                    "ls" -> {}
                }
            }

            line.startsWith("dir") -> {
                pwd.createDir(pwd, line.substringAfter(" "))
                println("dir ${line.substringAfter(' ')}")
            }

            else -> {
                val (size, name) = line.split(' ')
                println("$size $name")
                pwd.createFile(name, size.toInt())
            }
        }
    }

    return root
}

fun part1(root: Directory, size: Int): Int =
    findDirectories(root) { it.size <= size }.sumOf { it.size }

fun part2(root: Directory): Int =
    findDirectories(root) { it.size >= 30000000 - (70000000 - root.size) }.minBy { it.size }.size

private fun findDirectories(directory: Directory, predicate: Predicate<Directory>): List<Directory> {
    val dirs = mutableListOf<Directory>()
    if (predicate.test(directory)) dirs.add(directory)
    directory.ls().filterIsInstance<Directory>().forEach {
        dirs.addAll(findDirectories(it, predicate))
    }
    return dirs
}

open class File(val name: String, open val size: Int) {
    override fun toString(): String = name
}

class Directory(
    name: String,
    private val parent: Directory? = null,
    private var children: MutableList<File> = mutableListOf()
) : File(name, 0) {

    override val size: Int
        get() = children.sumOf { it.size }

    fun cd(name: String): Directory = when (name) {
        ".." -> parent!!
        else -> children.single { it.name == name } as Directory
    }

    fun ls(): List<File> = this.children

    fun createFile(name: String, size: Int) {
        children.add(File(name, size))
    }

    fun createDir(parent: Directory, name: String) {
        children.add(Directory(name, parent))
    }
}
