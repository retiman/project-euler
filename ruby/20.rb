# time ruby 20.rb
# 648
# 0.14user 0.00system 0:00.14elapsed 100%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1232minor)pagefaults 0swaps

puts (1..100).inject(&:*).to_s.chars.map { |c| c.to_i }.inject(&:+)
