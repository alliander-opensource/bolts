class: middle, center

# No Ifs Were Given

???

* Java Guild meeting 2021-04-15
* Following Brian Vermeer
* Platform for everybody

---
class: middle, center

![Anti If Campaign](image/anti-if.png)

???

* Anti-if campaign
* Founded 2009 by Francesco Cirillo  
* Mission: raise awareness of effective use of the Object-Oriented paradigm
* Anecdote: It used to be free, now it is a not

* Is this serious? No

---
class: middle, center

![Bob Ross; champion of deliberate practice](image/bob-ross.png)


???

* Deliberate practice
* Lot of developers are self taught
* Their hard-earned knowledge is a rite of passage
* There are other ways

---

## FizzBuzz

> Players generally sit in a circle.
> The player designated to go first says the number "1", and the players then count upwards in turn.
>
> However, any number divisible by three is replaced by the word fizz and any number divisible by five by the word buzz. Numbers divisible by 15 become fizz buzz.

--

```
1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, ...
```

???

* **Create a program htat prints out the first 100 FizzBuzz numbers
* According to wikipedia it is used as an interview question
* There are a lot of things wrong with that practice

---

```kotlin
class Classic {
    fun of(n: Int): String {
        if (n % 15 == 0) { return "FizzBuzz" }
        if (n % 5 == 0) { return "Buzz" }
        if (n % 3 == 0) { return "Fizz" }
        return n.toString()
    }
}
```

--

```kotlin
val fizzbuzz = Classic()
fizzbuzz.of(1)  // "1"
fizzbuzz.of(5)  // "Buzz"
fizzbuzz.of(6)  // "Fizz"
fizzbuzz.of(15) // "FizzBuzz"
```

???

* Classic solution to the FizzBuzz problem
* heavily relies on if
* Goal is to use object-oriented techniques
* Instead of writing if without literally writing `if`. No when, loop, or goto!

---

```kotlin
class FizzBuzz {
    fun of(n: Int): String {
        if (n % 15 == 0) { return "FizzBuzz" }
        if (n % 5 == 0) { return "Buzz" }
        if (n % 3 == 0) { return "Fizz" }
        if (true) { return n.toString() }
        return "Never going to happen"
    }
}
```

???

* With the introduction of a trivial test, the structure stands out!
* There are rules

---

```kotlin
class FizzBuzz {
    fun of(n: Int): String {
        return if (n % 15 == 0) { "FizzBuzz" } else { null } ?:
            if (n % 5 == 0) { "Buzz" } else { null } ?:
            if (n % 3 == 0) { "Fizz" } else { null } ?:
            if (true) { n.toString() } else { null } ?:
            "Never going to happen"
    }
}
```

???

* Multiple return statements are tricky, lets keep only 1
* Be explicit about not handling a case by using `null`
* Use the elvis operator to chain operations ensuring a result

---

```kotlin
interface Rule {
    apply(n : Int): String?
}
```

--

```kotlin
data class Divisible(val d: Int, val alternative: String): Rule {
    override fun apply(n: Int): String? =
       if (n % d == 0) {
           alternative
       } else {
           null
       }
}
```

```kotlin
object Just: Rule {
    override fun apply(n: Int): String? =
        n.toString()
}
```

???

* The rule is made explicit
* With two concrete implementations

---

```kotlin
class FizzBuzz {
    fun of(n: Int): String {
        return Divisible(15, "FizzBuzz").apply(n) ?:
            Divisible(5, "Buzz").apply(n) ?:
            Divisible(3, "Fizz").apply(n) ?:
            Just.apply(n) ?:
            "Never going to happen"
    }
}
```

???

* This brought the number of `if`s down from 4 to 1

---

```kotlin
data class Divisible(val d: Int, val alternative: String): Rule {
    override fun apply(n: Int): String? =
       if (n % d == 0) {
           alternative
       } else {
           null
       }
}
```

--

```kotlin
data class Divisible(val d: Int, val alternative: String) : Rule {
    val moduli : Map<Int, String?> = mapOf(0 to alternative)

    override fun apply(n: Int): String? =
        moduli.getOrDefault(n % divisor, null)
}
```

---

```kotlin
object Just: Rule {
    override fun apply(n: Int): String =
        n.toString()
}
```

```kotlin
class FizzBuzz {
    fun of(n: Int): String {
        return Divisible(15, "FizzBuzz").apply(n) ?:
            Divisible(5, "Buzz").apply(n) ?:
            Divisible(3, "Fizz").apply(n) ?:
            Just.apply(n)
    }
}
```

???

* With covariant return types we can remove the "Never going to happen"
* since T <| T?

---

```kotlin
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
```

???

* With some functional programming sprinkled on top
* We can separate the configuration from the implementation

---
class: middle, center

## Why

---
class: middle, center

![Code Retreat](image/coderetreat.png)

???

* Like to practice
* With others
* Let's organize a code retreat

---
class: middle, center

## Questions