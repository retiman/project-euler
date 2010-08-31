# time ruby 21.rb
# 31626
# 3.10user 0.40system 0:03.58elapsed 97%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1683minor)pagefaults 0swaps

def divisors(n)
  d = (2..Math.sqrt(n)).select { |q| n%q == 0 }
  d = d + d.map { |q| n / q } + [1]
  d.uniq
end

def sigma(n)
  divisors(n).inject(&:+)
end

limit = 10000
result = (2..limit).map { |n| [n, sigma(n)] }.
                    select { |t| t.first > t.last && t.first == sigma(t.last) }.
                    map { |t| t.first + t.last }.
                    inject(&:+)
puts result
