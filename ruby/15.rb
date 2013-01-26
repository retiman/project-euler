def fact(n)
  (1..n).inject(&:*)
end
puts fact(20+20) / (fact(20) * fact(20))
