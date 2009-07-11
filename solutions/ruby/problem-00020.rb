#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00020.rb 
# 648
#
# real  0m0.022s
# user  0m0.012s
# sys 0m0.004s
puts (1..100).inject(:*).to_s.chars.map { |c| c.to_i }.inject(:+)
