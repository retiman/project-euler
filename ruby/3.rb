# time ruby 3.rb
# 6857
# 0.48user 0.02system 0:00.52elapsed 95%CPU (0avgtext+0avgdata 0maxresident)k
# 120inputs+0outputs (1major+1235minor)pagefaults 0swaps

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
