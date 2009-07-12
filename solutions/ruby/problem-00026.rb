#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00026.rb 
# 983
#
# real  0m0.032s
# user  0m0.016s
# sys 0m0.008s
class Array
  def tail
    self.drop(1)
  end
end

def order(a, m)
  b = 1
  (1...m).each do |i|
    b = (a*b)%m
    return i if b == 1
  end
end

def max_period(best, numbers)
  return best if numbers.nil?
  n = numbers.first
  ord = order(10, n)
  return [n, ord] if ord == n - 1
  return max_period([n, ord], numbers.tail) if ord > best.last
  return max_period(best, numbers.tail)
end

numbers = 999.step(2, -1).select { |n| n % 2 != 0 && n % 5 != 0 }
result = max_period([0, 0], numbers)
puts result.first
