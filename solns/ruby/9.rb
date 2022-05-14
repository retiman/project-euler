n = 1000
result = 0
(1..332).each do |a|
  limit = ((n - a) / 2) - 1
  (a..limit).each do |b|
    c = n - a - b
    if (a * a) + (b * b) == c * c
      result = a * b * c
      break
    end
  end
end

puts result
raise Error unless result == 31_875_000
