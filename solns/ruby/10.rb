def sieve(limit)
  current = 2
  numbers = 0.upto(limit).to_a
  numbers[1] = 0
  while current < limit
    (2 * current..limit).step(current).each { |i| numbers[i] = 0 }
    loop do
      current += 1
      break unless current <= limit && (numbers[current]).zero?
    end
  end
  numbers.reject(&:zero?)
end

result = sieve(2_000_000).inject(&:+)

puts result
raise Error unless result == 142_913_828_922
