# time ruby 16.rb
# 1366
# 0.12user 0.00system 0:00.14elapsed 94%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1232minor)pagefaults 0swaps

puts (2 ** 1000).to_s.chars.map { |c| c.to_i }.inject(&:+)
