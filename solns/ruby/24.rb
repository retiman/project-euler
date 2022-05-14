$limit = 1_000_000

def fact(n)
  (1..n).inject(&:*)
end

def compute(list, curr)
  permutations = fact(list.length - 1)
  index = ($limit - curr) / permutations
  digit = list[index]
  succ = curr + (index * permutations)
  return list if list.length == 2 && ($limit - curr).zero?
  return list.reverse if list.length == 2 && $limit - curr == 1

  [digit] + compute(list.delete_if { |x| x == digit }, succ)
end

result = compute((0..9).to_a, 1).join.to_i

puts result
raise Error unless result == 2_783_915_460
