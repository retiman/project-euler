#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00002.rb 
# 4613732
#
# real    0m0.011s
# user    0m0.004s
# sys     0m0.004s
curr, succ, acc = 0, 1, 0
while curr < 4000000
  curr, succ = succ, curr + succ
  acc += curr if curr % 2 == 0
end
puts acc
