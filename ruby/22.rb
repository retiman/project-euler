# time ruby 22.rb
# 871198282
# 0.70user 0.10system 0:00.82elapsed 97%CPU (0avgtext+0avgdata 0maxresident)k
# 96inputs+0outputs (0major+1735minor)pagefaults 0swaps

def score(name)
  scores = Hash[('A'..'Z').zip(1..26)]
  name.chars.map { |c| scores[c] }.inject(&:+)
end

file = File.new("../data/22.txt")
data = file.gets.gsub("\"", "").split(",") # All one line in file
file.close

result = data.each_index.
              zip(data.sort).
              map { |t| (t.first+1) * score(t.last) }.
              inject(&:+)
puts result
