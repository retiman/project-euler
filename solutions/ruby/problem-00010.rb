# [minhuang@mocha:ruby]$ time ruby problem-00010.rb 
# 142913828922
#
# real    2m8.094s
# user    1m21.453s
# sys     0m45.147s
require 'mathn'
puts Prime.new.take_while { |p| p < 2000000}.inject(&:+)
