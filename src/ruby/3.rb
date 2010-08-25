# [minhuang@mocha:ruby]$ time ruby problem-00003.rb 
# 6857
#
# real    0m0.472s
# user    0m0.456s
# sys     0m0.004s
def fermat_factors(n)
  return [2, n/2] if n % 2 == 0
  a = Math.sqrt(n).ceil
  b = a*a-n
  s = Math.sqrt(b)
  while s != s.round
    a += 1
    b = a*a-n
    s = Math.sqrt(b)
  end
  [a-s, a+s]
end

def prime_factors(n)
  factors = fermat_factors(n)
  if factors.include? 1
    factors.delete_if { |f| f == 1 }
  else
    factors.map { |f| prime_factors(f) }.inject(&:concat)
  end
end

puts prime_factors(600851475143).max.round
