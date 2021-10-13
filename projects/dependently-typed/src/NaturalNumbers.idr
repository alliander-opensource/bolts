module NaturalNumberExample

data NaturalNumber : Type where
    Zero : NaturalNumber
    Successor : NaturalNumber -> NaturalNumber

-- Definition of add
add : NaturalNumber -> NaturalNumber -> NaturalNumber
add Zero y = y
add (Successor x) y = Successor (add x y)

-- Interactive definition of plus, a synonym of add
-- Try the following key combinations
-- 1. Ctrl + Shift + D on `plus`
-- 2. Ctrl + Shift + C on `x`
-- 3. Ctrl + Shift + O on `?plus_rhs_1`
-- 4. Ctrl + Shift + T on `?plus_rhs_2`
plus : NaturalNumber -> NaturalNumber -> NaturalNumber

-- Make the classic recursive mistake: `plus x y = plus x y`.
-- But add the `total` keyword.

-- `NaturalNumber`s are in the standard library known as
-- data Nat : Type where
--    Z : Nat
--    S : Nat -> Nat
