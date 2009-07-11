#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00009.rb 
# 31875000
#
# real  0m0.085s
# user  0m0.068s
# sys 0m0.012s
n = 1000
(1..332).each do |a|
  limit = ((n - a) / 2) - 1
  (a..limit).each do |b|
    c = n - a - b
    puts a*b*c if a*a + b*b == c*c
  end
end
