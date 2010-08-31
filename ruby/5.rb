# time ruby 5.rb
# 232792560
# 0.11user 0.01system 0:00.20elapsed 62%CPU (0avgtext+0avgdata 0maxresident)k
# 32inputs+0outputs (0major+1232minor)pagefaults 0swaps

def gcd(a, b)
  if b == 0 then a else gcd(b, a % b) end
end

def lcm(a, b)
  a * (b / gcd(a, b))
end

puts (1..20).inject(20) { |a, b| lcm(a, b) }
