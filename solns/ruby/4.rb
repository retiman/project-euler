def palindrome?(n)
  n.to_s == n.to_s.reverse
end

result = 0
999.step(1, -1).each do |i|
  i.step(1, -1).each do |j|
    x = i * j
    result = x if palindrome?(x) && x > result
  end
end

puts result
raise Error unless result == 906_609
