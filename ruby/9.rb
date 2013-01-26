n = 1000
(1..332).each do |a|
  limit = ((n - a) / 2) - 1
  (a..limit).each do |b|
    c = n - a - b
    puts a*b*c if a*a + b*b == c*c
  end
end
