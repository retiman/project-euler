# time ruby 1.rb
# 233168
# 0.12user 0.01system 0:00.14elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1231minor)pagefaults 0swaps

puts (1..999).select { |x| x % 3 == 0 || x % 5 == 0 }.inject(&:+)
