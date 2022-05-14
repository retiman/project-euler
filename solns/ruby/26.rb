class Array
  def tail
    drop(1)
  end
end

def order(a, m)
  b = 1
  (1...m).each do |i|
    b = (a * b) % m
    return i if b == 1
  end
end

def max_period(best, numbers)
  return best if numbers.nil?

  n = numbers.first
  ord = order(10, n)
  return [n, ord] if ord == n - 1
  return max_period([n, ord], numbers.tail) if ord > best.last

  max_period(best, numbers.tail)
end

numbers = 999.step(2, -1).select { |n| n.odd? && n % 5 != 0 }
result = max_period([0, 0], numbers)
result = result.first

puts result
raise Error unless result == 983
