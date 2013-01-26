curr, succ, acc = 0, 1, 0
while curr < 4000000:
  curr, succ = succ, curr + succ
  if curr % 2 == 0:
    acc += curr
print(acc)
