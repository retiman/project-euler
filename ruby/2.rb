curr, succ, acc = 0, 1, 0
while curr < 4000000
  curr, succ = succ, curr + succ
  acc += curr if curr % 2 == 0
end
result = acc

puts result
raise Error unless result == 4613732
