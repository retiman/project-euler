puts (2 ** 1000).to_s.chars.map { |c| c.to_i }.inject(&:+)
