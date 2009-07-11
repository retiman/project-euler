#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00015.rb 
# 137846528820
#
# real  0m0.022s
# user  0m0.016s
# sys 0m0.008s
def fact(n)
  (1..n).inject(:*)
end
puts fact(20+20) / (fact(20) * fact(20))
