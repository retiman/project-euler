def gcd(a, b)
  if b == 0 then a else gcd(b, a % b) end
end

def lcm(a, b)
  a * (b / gcd(a, b))
end

puts (1..20).inject(20) { |a, b| lcm(a, b) }
