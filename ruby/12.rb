# time ruby 12.rb
# 76576500
# 149.73user 22.46system 2:54.27elapsed 98%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1233minor)pagefaults 0swaps

def tau(n)
  return 1 if n == 1
  2 * (1..Math.sqrt(n)).select { |i| n % i == 0}.length
end

n, i = 3, 3
while tau(n) < 500
  n, i = n+i, i+1
end
puts n
