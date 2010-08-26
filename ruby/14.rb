# [minhuang@mocha:ruby]$ time ruby problem-00014.rb 
# 837799
#
# real  0m14.578s
# user  0m14.201s
# sys 0m0.164s
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
