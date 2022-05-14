def divisors(n)
  d = (2..Math.sqrt(n)).select { |q| (n % q).zero? }
  d = d + d.map { |q| n / q } + [1]
  d.uniq
end

def sigma(n)
  divisors(n).inject(&:+)
end

limit = 28_123
abundants = (1..limit).select { |n| sigma(n) > n }
numbers = (0..limit).to_a

(0...abundants.length).each do |i|
  (i...abundants.length).each do |j|
    index = abundants[i] + abundants[j]
    numbers[index] = 0 if index <= limit
  end
end

result = numbers.inject(&:+)

puts result
raise Error unless result == 4_179_871
