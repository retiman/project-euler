#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00021.rb 
# 31626
#
# real  0m1.385s
# user  0m1.356s
# sys 0m0.004s
def divisors(n)
  d = (2..Math.sqrt(n)).select { |q| n%q == 0 }
  d = d + d.map { |q| n / q } + [1]
  d.uniq
end

def sigma(n)
  divisors(n).inject(:+)
end

limit = 10000
result = (2..limit).map { |n| [n, sigma(n)] }
result = result.select { |t| t.first > t.last && t.first == sigma(t.last) }
result = result.map { |t| t.first + t.last }
result = result.inject(:+)
puts result
