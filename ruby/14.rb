# time ruby 14.rb
# 837799
# 22.95user 2.76system 0:26.56elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+19537minor)pagefaults 0swaps

$map = {1 => 1}

def collatz(n)
  value = $map[n]
  return value unless value.nil?
  return 1+collatz(n/2) if n%2 == 0
  return 1+collatz(3*n+1)
end

def f(n)
  value = collatz(n)
  $map[n] = value if $map[n].nil?
  [n, value]
end

def max(a, b)
  if a.last > b.last then a else b end
end

limit = 1000000
puts (1..limit).map { |n| f(n) }.inject([0,0]) { |a, b| max(a,b) }.first
