$map = { 1 => 1 }

def collatz(n)
  value = $map[n]
  return value unless value.nil?
  return 1 + collatz(n / 2) if n.even?

  1 + collatz(3 * n + 1)
end

def f(n)
  value = collatz(n)
  $map[n] = value if $map[n].nil?
  [n, value]
end

def max(a, b)
  a.last > b.last ? a : b
end

limit = 1_000_000
result = (1..limit).map { |n| f(n) }.inject([0, 0]) { |a, b| max(a, b) }.first

puts result
raise Error unless result == 837_799
