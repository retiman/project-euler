# 4613732
# 0.03user 0.01system 0:00.05elapsed 94%CPU (0avgtext+0avgdata 7196maxresident)k
# 0inputs+0outputs (0major+1903minor)pagefaults 0swaps

curr, succ, acc = 0, 1, 0
while curr < 4000000:
  curr, succ = succ, curr + succ
  if curr % 2 == 0:
    acc += curr
print(acc)
