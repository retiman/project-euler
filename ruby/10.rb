# time ruby 10.rb
# 142913828922
# 13.89user 3.00system 0:17.11elapsed 98%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+3364minor)pagefaults 0swaps

def sieve(limit)
  current = 2
  numbers = 0.upto(limit).to_a
  numbers[1] = 0
  while (current < limit)
    (2 * current .. limit).step(current).each { |i| numbers[i] = 0 }
    begin
      current += 1
    end while current <= limit && numbers[current] == 0
  end
  numbers.select { |n| n != 0 }
end

result = sieve(2_000_000).inject(&:+)
puts result
