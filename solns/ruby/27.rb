require "set"

# A simple quadratic
def f(n, a, b)
  n*n + a*n + b
end

# For how many values is a quadratic prime?
def count(ps, a, b)
  (0..b).take_while { |n| ps.include? f(n, a, b) }.count
end

# A list of the primes under 2 million will be fine
def primes
  file = File.new("../data/primes.txt")
  set = Set.new
  while (p = file.gets)
    set.add(p.to_i)
  end
  file.close
  set
end


b_max   = 1000
ps      = primes
bs      = ps.select { |b| b <= b_max }
bs      = bs + bs.map { |b| -b }
a, b, c = 0, 0, 0

bs.each do |b_i|
  (-b_max..b_max).each do |a_i|
    c_i = count(ps, a_i, b_i)
    if c_i > c
      a, b, c = a_i, b_i, c_i
    end
  end
end

result = a*b

puts result
raise Error unless result == -59231
