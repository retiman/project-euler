puts (1..100).inject(&:*).to_s.chars.map { |c| c.to_i }.inject(&:+)
