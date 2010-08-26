# [minhuang@mocha:ruby]$ time ruby problem-00025.rb 
# 4782
#
# real  0m1.719s
# user  0m1.676s
# sys 0m0.012s
i, curr, succ = 0, 0, 1
while curr.to_s.length < 1000
  i, curr, succ = i + 1, succ, curr + succ
end
puts i
