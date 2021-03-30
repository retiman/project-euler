fact n = product [1..n]
main = print result
       where num = fact 40
             denom = (fact 20) * (fact 20)
             result = div num denom
