curr = 0
succ = 1
acc = 0

while curr < 4_000_000
  curr, succ = succ, curr + succ
  acc += curr if curr.even?
end

result = acc
puts result
raise Error unless result == 4_613_732
