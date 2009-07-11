#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00006.rb 
# 25164150
#
# real    0m0.017s
# user    0m0.004s
# sys     0m0.008s
a = (1..100).map { |i| i * i }.inject(&:+)
b = (1..100).inject(&:+)
puts b*b - a
