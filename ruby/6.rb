# time ruby 6.rb
# 25164150
# 0.13user 0.02system 0:00.16elapsed 98%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1232minor)pagefaults 0swaps

a = (1..100).map { |i| i * i }.inject(&:+)
b = (1..100).inject(&:+)
puts b*b - a
