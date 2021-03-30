result = (2 ** 1000).to_s.chars.map { |c| c.to_i }.inject(&:+)

puts result
raise Error unless result == 1366
