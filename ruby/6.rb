a = (1..100).map { |i| i * i }.inject(&:+)
b = (1..100).inject(&:+)
puts b*b - a
