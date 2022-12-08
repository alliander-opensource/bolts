layout: true
class: middle, center


---

# Logic Programming

--

## an introduction

---

# Pet Peeve

---

# Programming Paradigm

> a way to classify programming languages based on their features

---

# Imperative Programming

???

* E.g. Java
* Focus on the *how*
* Programmer instructs the computer what to do
* Sub-paradigms: procedural, object-oriented

---

.code[
```java
int s = 0;
for (int i = 0; i < 10; i++){
    s += i;
}
System.out.println(s);
```
]

---

# Declarative Programming

???

* E.g. SQL
* Focus on the *what*
* Programmer tells the computer what it wants to know
* Sub-paradigms: Functional, *logic*

---

.code[
```sql
select * from ideas where topic='software'
```
]

---

### If it rains then the ground gets wet

---

# If `A` then `B`

---

# `A => B`

---

# `B <= A`

---

# `B :- A`

---

# Horn Clause

--

## `B :- A`

---

# [Syllogism Demo](https://swish.swi-prolog.org/p/guild-00.pl)

---

# Horn Clause

## `B :- A_1, A_2, ..., A_n`

---

# [Rainbow Demo](https://swish.swi-prolog.org/p/guild-01.pl)

---

# List

--

* Empty: `[]`

--
* Cons: `[H|T]`

--

### `[1,2,3]` shorthand `[1|2[3|[]]]`

---

# [Member Demo](https://swish.swi-prolog.org/p/guild-02.pl)

---

# Unification

---

# [Tree Demo](https://swish.swi-prolog.org/p/guild-03.swinb)

---

# So, now what?