result = (1..999).select { |x| x % 3 == 0 || x % 5 == 0 }.inject(&:+)

puts result
raise Error unless result == 233168
