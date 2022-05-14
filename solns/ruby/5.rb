def gcd(a, b)
  b.zero? ? a : gcd(b, a % b)
end

def lcm(a, b)
  a * (b / gcd(a, b))
end

result = (1..20).inject(20) { |a, b| lcm(a, b) }

puts result
raise Error unless result == 232_792_560
