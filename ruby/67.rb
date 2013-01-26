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
