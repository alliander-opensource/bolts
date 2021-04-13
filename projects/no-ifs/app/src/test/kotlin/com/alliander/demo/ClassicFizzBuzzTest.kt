package com.alliander.demo

import io.kotest.core.datatest.forAll
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ClassicFizzBuzzTest : ShouldSpec({
    val fizzbuzz = Classic()

    context("determine the fizzbuzz of input") {
        forAll(
            Expectation(1, "1"),
            Expectation(2, "2"),
            Expectation(3, "Fizz"),
            Expectation(5, "Buzz"),
            Expectation(6, "Fizz"),
            Expectation(10, "Buzz"),
            Expectation(15, "FizzBuzz"),
        ) { (n, expected) ->
            fizzbuzz.of(n) shouldBe expected
        }
    }
})

data class Expectation(val onInput: Int, val expect: String)
