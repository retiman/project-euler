# time ruby 15.rb
# 137846528820
# 0.10user 0.03system 0:00.14elapsed 98%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1232minor)pagefaults 0swaps

def fact(n)
  (1..n).inject(&:*)
end
puts fact(20+20) / (fact(20) * fact(20))
