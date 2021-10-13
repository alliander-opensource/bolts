module VectorExample

data Vector : Nat -> Type -> Type where
    Empty : Vector 0 a
    (::)  : (x : a) -> (xs : Vector k a) -> Vector (S k) a

%name Vector xs, ys, zs

-- Interactive definition of append
-- append (1 :: 2 :: Empty) (3 :: Empty) == 1 :: 2 :: 3 :: Empty
append : Vector m a -> Vector n a -> Vector (m + n) a

-- Interactive definition of zip
-- zip (1 :: 2 :: Empty) ('a' :: 'b' :: Empty) = (1, 'a') :: (2, 'b') :: Empty
zip : Vector n a -> Vector n b -> Vector n (a, b)


-- Definition of head
-- What type should `head` have?
-- head

-- `Vector`s are in the standard library known as `Vec`.
