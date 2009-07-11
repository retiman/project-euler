#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00001.rb 
# 233168
#
# real    0m0.016s
# user    0m0.012s
# sys     0m0.008s
result = (1..999).select { |x| x % 3 == 0 || x % 5 == 0 }.inject(:+)
puts result
