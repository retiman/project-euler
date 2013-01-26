i, curr, succ = 0, 0, 1
while curr.to_s.length < 1000
  i, curr, succ = i + 1, succ, curr + succ
end
puts i
