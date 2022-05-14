def fact(n)
  (1..n).inject(&:*)
end
result = fact(20 + 20) / (fact(20) * fact(20))

puts result
raise Error unless result == 137_846_528_820
