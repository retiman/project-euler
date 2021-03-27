a = (1..100).map { |i| i * i }.inject(&:+)
b = (1..100).inject(&:+)
result = b * b - a

puts result
raise Error unless result == 25164150
