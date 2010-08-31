# time ruby 9.rb
# 31875000
# 0.29user 0.04system 0:00.34elapsed 99%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1232minor)pagefaults 0swaps

n = 1000
(1..332).each do |a|
  limit = ((n - a) / 2) - 1
  (a..limit).each do |b|
    c = n - a - b
    puts a*b*c if a*a + b*b == c*c
  end
end
