# time ruby 4.rb
# 906609
# 2.94user 0.25system 0:03.35elapsed 95%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+1232minor)pagefaults 0swaps

def is_palindrome(n)
  n.to_s == n.to_s.reverse
end

result = 0
999.step(1, -1).each do |i|
  i.step(1, -1).each do |j|
    x = i*j
    if is_palindrome(x) && x > result
      result = x
    end
  end
end
puts result
