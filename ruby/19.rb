# time ruby 19.rb
# 171
# 0.35user 0.02system 0:00.38elapsed 97%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1233minor)pagefaults 0swaps

require 'date'
sundays = 0
(1901..2000).each do |year|
  (1..12).each do |month|
    d = Date.new(year, month, 1)
    sundays += 1 if d.cwday == 7 # Sunday
  end
end
puts sundays
