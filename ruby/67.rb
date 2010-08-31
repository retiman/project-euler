# time ruby 67.rb
# 7273
# 0.15user 0.02system 0:00.19elapsed 90%CPU (0avgtext+0avgdata 0maxresident)k
# 32inputs+0outputs (0major+1233minor)pagefaults 0swaps

data = []
file = File.new("../data/67.txt")
while line = file.gets
  data << line
end
file.close

data = data.map { |l| l.strip }.
            select { |l| l != "" }.
            map { |l| l.split(" ").map { |s| s.to_i } }

(data.length - 2).step(0, -1).each do |i|
  (0...data[i].length).each do |j|
    left = data[i+1][j]
    right = data[i+1][j+1]
    data[i][j] += [left, right].max
  end
end

puts data[0][0]
