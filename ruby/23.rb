# [minhuang@mocha:ruby]$ time ruby problem-00023.rb 
# 4179871
#
# real  0m20.567s
# user  0m20.397s
# sys 0m0.048s

def divisors(n)
  d = (2..Math.sqrt(n)).select { |q| n%q == 0 }
  d = d + d.map { |q| n / q } + [1]
  d.uniq
end

def sigma(n)
  divisors(n).inject(&:+)
end

limit = 28123
abundants = (1..limit).select { |n| sigma(n) > n }
numbers = (0..limit).to_a

(0...abundants.length).each do |i|
  (i...abundants.length).each do |j|
    index = abundants[i] + abundants[j]
    numbers[index] = 0 if index <= limit
  end
end

puts numbers.inject(&:+)
