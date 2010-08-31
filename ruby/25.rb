# time ruby 25.rb
# 4782
# 1.19user 0.02system 0:01.30elapsed 93%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+2026minor)pagefaults 0swaps

i, curr, succ = 0, 0, 1
while curr.to_s.length < 1000
  i, curr, succ = i + 1, succ, curr + succ
end
puts i
