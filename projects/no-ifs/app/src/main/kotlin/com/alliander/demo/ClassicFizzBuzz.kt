package com.alliander.demo

class Classic {
    fun of(n: Int): String {
        if (n % 15 == 0) { return "FizzBuzz" }
        if (n % 5 == 0) { return "Buzz" }
        if (n % 3 == 0) { return "Fizz" }
        return n.toString()
    }
}
