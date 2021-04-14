package com.alliander.demo

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class NoIfFizzBuzzTest : StringSpec({
    val classic = Classic()
    val noIf = FizzBuzz()

    "classic and no-if should agree on all inputs" {
        checkAll { n: Int ->
            classic.of(n) shouldBe noIf.of(n)
        }
    }
})
