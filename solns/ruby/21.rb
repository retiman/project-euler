def divisors(n)
  d = (2..Math.sqrt(n)).select { |q| (n % q).zero? }
  d = d + d.map { |q| n / q } + [1]
  d.uniq
end

def sigma(n)
  divisors(n).inject(&:+)
end

limit = 10_000
result = (2..limit).map { |n| [n, sigma(n)] }
                   .select { |t| t.first > t.last && t.first == sigma(t.last) }
                   .map { |t| t.first + t.last }
                   .inject(&:+)

puts result
raise Error unless result == 31_626
