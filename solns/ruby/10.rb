def sieve(limit)
  current = 2
  numbers = 0.upto(limit).to_a
  numbers[1] = 0
  while (current < limit)
    (2 * current .. limit).step(current).each { |i| numbers[i] = 0 }
    begin
      current += 1
    end while current <= limit && numbers[current] == 0
  end
  numbers.select { |n| n != 0 }
end

result = sieve(2_000_000).inject(&:+)

puts result
raise Error unless result == 142913828922
