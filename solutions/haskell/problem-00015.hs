{-
[minhuang@mocha:haskell]$ time runghc problem-00015.hs 
137846528820

real  0m0.617s
user  0m0.512s
sys 0m0.056s
-}
fact n = product [1..n]
main = print result
       where num = fact 40
             denom = (fact 20) * (fact 20)
             result = div num denom
