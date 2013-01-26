puts (1..999).select { |x| x % 3 == 0 || x % 5 == 0 }.inject(&:+)
