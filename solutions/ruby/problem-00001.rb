#!/usr/bin/env ruby
result = (1..999).find_all { |x| x % 3 == 0 || x % 5 == 0 }.inject(0) { |acc, x| acc + x }
puts result
