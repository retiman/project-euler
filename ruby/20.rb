result = (1..100).inject(&:*).to_s.chars.map { |c| c.to_i }.inject(&:+)

puts result
raise Error unless result == 648
