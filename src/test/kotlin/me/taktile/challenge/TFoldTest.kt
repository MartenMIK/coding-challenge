package me.taktile.challenge

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TFoldTest {

    private val addition: ((Int, Int) -> Int) = { a, b -> a + b }

    @Test
    fun testAllElementsEffected() {
        val list = listOf(1, 2, 3)
        val foldResult = list.tFold(0, addition)
        assertEquals(6, foldResult)
    }

    @Test
    fun testInitial() {
        val list = listOf(5)
        assertEquals(5, list.tFold(0, addition))
        assertEquals(10, list.tFold(5, addition))
    }

    @Test
    fun testEmptyList() {
        val list = emptyList<Int>()
        assertEquals(0, list.tFold(0, addition))
        assertEquals(5, list.tFold(5, addition))
    }

    @Test
    fun testDirectionIsFirstToLast() {
        val concat: ((String, String) -> String) = { a, b -> b + a }
        val list = listOf(", ", "World", "!")
        assertEquals("Hello, World!", list.tFold("Hello", concat))
    }

    @Test
    fun testDifferentTypes() {
        val concat: ((Char, String) -> String) = { a, b -> b + a }
        val list = listOf('W', 'o', 'r', 'l', 'd', '!')
        assertEquals("World!", list.tFold("", concat))
        assertEquals("Hello, World!", list.tFold("Hello, ", concat))
    }
}
