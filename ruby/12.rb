def tau(n)
  return 1 if n == 1
  2 * (1..Math.sqrt(n)).select { |i| n % i == 0}.length
end

n, i = 3, 3
while tau(n) < 500
  n, i = n+i, i+1
end
puts n
