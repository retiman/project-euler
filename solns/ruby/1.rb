result = (1..999).select { |x| (x % 3).zero? || (x % 5).zero? }.inject(&:+)

puts result
raise Error unless result == 233_168
