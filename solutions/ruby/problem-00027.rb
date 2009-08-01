#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ./problem-00027.rb 
# -59231
#
# real    2m2.237s
# user    1m19.561s
# sys     0m41.859s
require 'mathn'
require 'set'

# A simple quadratic
def f(n, a, b)
  n*n + a*n + b
end

# For how many values is a quadratic prime?
def count(ps, a, b)
  c = 0
  (0..b).each do |n|
    v = f(n, a, b)
    if ps.include? v
      c += 1
    else
      return c
    end
  end
  c
end

b_max   = 1000
p_max   = f(b_max, b_max, b_max)
ps      = Prime.new.take_while { |p| p <= p_max }.to_set
bs      = ps.take_while { |b| b <= b_max }
bs      = bs + bs.map { |b| -b }
a, b, c = 0, 0, 0

bs.each do |b_i|
  (-b_max..b_max).each do |a_i|
    c_i = count(ps, a_i, b_i)
    if c_i > c
      a, b, c = a_i, b_i, c_i
    end
  end
end

puts a*b
