-- a)
-- why using Integer as Variable is OK? The output is no different by using different variables.
-- What does _ mean in pattern?
-- fibInit :: Int->Int->Int->Int
fibInit :: Integer->Integer->Integer->Integer
fibInit a0 _  0 = a0
fibInit _  a1 1 = a1
fibInit a0 a1 n = fibInit a0 a1 (n-1) + fibInit a0 a1 (n-2)

-- b)
fibInitL :: Integer->Integer->Integer->[Integer]
fibInitL _ _ (-1) = []
fibInitL a0 a1 n = a0 : fibInitL a1 (a0 + a1) (n - 1)

fibInit2 :: Integer->Integer->Integer->Integer
fibInit2 a0 a1 n = lastElem $ fibInitL a0 a1 n
    where
        lastElem [x]    = x
        lastElem (x:xs) = lastElem xs
-- lastElem $ fibInitL a0 a1 n
-- is equivalent to 
-- lastElem (fibInitL a0 a1 n)

-- c)
normalize :: [Integer]->[Integer]
normalize xs = subList xs $ minList xs
    where 
        minList :: [Integer]->Integer
        minList [x] = x
        minList (min:x:xs)
            | min > x   = minList (x:xs)
            | otherwise = minList (min:xs)

        subList :: [Integer]->Integer->[Integer]
        subList []     _ = []
        subList (x:xs) k = ( x - k ) : subList xs k
        -- k is the smellest nummer in input list.

-- d)
sumMaxs :: [Integer]->Integer
sumMaxs (x:xs) = x + help x xs
    where 
        help _ [] = 0
        help max (x:xs)
            | x > max = x + help x xs
            | otherwise = help max xs
{-
sumMaxs [2,1,2,5,4]
= sumMaxs (2:[1,2,5,4])
= 2 + help 2 (2:[1,2,5,4])
= 2 + help 2 [1,2,5,4]
= 2 + help 2 (1:[2,5,4])
= 2 + help 2 [2,5,4]
= 2 + help 2 (2:[5,4])
= 2 + help 2 [5,4]
= 2 + help 2 (5:[4])
= 2 + ( 5 + help 5 [4] )
= 2 + ( 5 + help 5 (4:[]) )
= 2 + ( 5 + help 5 [] )
= 2 + ( 5 + 0 )
-}

-- e)
sumNonMins :: [Integer]->Integer
sumNonMins (x:xs) = help x xs
    where 
        help _ [] = 0
        help min (x:xs)
            | x > min = x + help min xs
            | otherwise = help x xs

-- f) 
prime :: Integer -> Bool
prime 0 = False
prime 1 = False
prime 2 = True
prime n = primeTest n (n - 1)
    where
        primeTest :: Integer->Integer->Bool
        primeTest n m
            | m       == 1 = True
            | rem n m == 0 = False
            | otherwise    = primeTest n (m - 1)

primeTwins :: Integer -> (Integer, Integer)
primeTwins n 
    | prime (n+1) && prime (n+3) = ((n+1) , (n+3))
    | otherwise                  =  primeTwins (n+1)

-- g)
multiples :: [Integer] -> Integer -> Integer -> [Integer]
multiples [] _ _ = []
multiples (x:xs) n m
    | n /= m = multiples (x:xs) n n ++ multiples (x:xs) (n+1) m
    | rem n x == 0 = [n]
    | otherwise = multiples xs n m