def is_palindrome(n)
  n.to_s == n.to_s.reverse
end

result = 0
999.step(1, -1).each do |i|
  i.step(1, -1).each do |j|
    x = i*j
    if is_palindrome(x) && x > result
      result = x
    end
  end
end
puts result
