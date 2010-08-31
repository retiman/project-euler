# time ruby 2.rb
# 4613732
# 0.08user 0.01system 0:00.10elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1232minor)pagefaults 0swaps

curr, succ, acc = 0, 1, 0
while curr < 4000000
  curr, succ = succ, curr + succ
  acc += curr if curr % 2 == 0
end
puts acc
