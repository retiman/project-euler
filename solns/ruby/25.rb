i = 0
curr = 0
succ = 1
i, curr, succ = i + 1, succ, curr + succ while curr.to_s.length < 1000
result = i

puts result
raise Error unless result == 4782
