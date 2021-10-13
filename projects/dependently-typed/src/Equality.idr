module EqualityExample

-- This function expresses the theorem that when two lists are equal
-- and equal elements are added to the front
-- the resulting lists are equal
same_cons : {xs : List a} -> {ys : List a} -> xs = ys -> x :: xs = x :: ys

-- cong is has the following signature
-- cong : { f : a -> b } -> x = y -> f x = f y
-- what does it express?