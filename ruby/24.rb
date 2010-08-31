# time ruby 24.rb
# 2783915460
# 0.08user 0.00system 0:00.13elapsed 67%CPU (0avgtext+0avgdata 0maxresident)k
# 24inputs+0outputs (0major+1232minor)pagefaults 0swaps

$limit = 1_000_000

def fact(n)
  (1..n).inject(&:*)
end

def compute(list, curr)
  permutations = fact(list.length - 1)
  index = ($limit - curr) / permutations
  digit = list[index]
  succ = curr + index * permutations
  if list.length == 2 && $limit - curr == 0
    return list
  end
  if list.length == 2 && $limit - curr == 1
    return list.reverse
  end
  return [digit] + compute(list.delete_if { |x| x == digit }, succ)
end

puts compute((0..9).to_a, 1).join.to_i
