package com.alliander.demo

class FizzBuzz {
    val rules: Collection<Rule> = listOf(
        Divisible(15, "FizzBuzz"),
        Divisible(5, "Buzz"),
        Divisible(3, "Fizz"),
        Just,
    )

    fun of(n: Int): String {
        return rules
            .map { it.apply(n) }
            .reduce { l, r -> l ?: r }
            as String
    }
}

interface Rule {
    fun apply(n: Int): String?
}

data class Divisible(val divisor: Int, val alternative: String) : Rule {
    val moduli : Map<Int, String?> = mapOf(0 to alternative)

    override fun apply(n: Int): String? =
        moduli.getOrDefault(n % divisor, null)
}

object Just : Rule {
    override fun apply(n: Int): String =
        n.toString()
}
