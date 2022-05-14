def tau(n)
  return 1 if n == 1

  2 * (1..Math.sqrt(n)).count { |i| (n % i).zero? }
end

n = 3
i = 3
while tau(n) < 500
  n += i
  i += 1
end
result = n

puts result
raise Error unless result == 76_576_500
