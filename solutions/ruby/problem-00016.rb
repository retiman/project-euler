#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00016.rb 
# 1366
#
# real  0m0.021s
# user  0m0.012s
# sys 0m0.012s
puts (2 ** 1000).to_s.chars.map { |c| c.to_i }.inject(:+)
