data = []
file = File.new('/data/67.txt')
while (line = file.gets)
  data << line
end
file.close

data = data.map(&:strip)
           .reject { |l| l == '' }
           .map { |l| l.split.map(&:to_i) }

(data.length - 2).step(0, -1).each do |i|
  (0...data[i].length).each do |j|
    left = data[i + 1][j]
    right = data[i + 1][j + 1]
    data[i][j] += [left, right].max
  end
end

result = data[0][0]

puts result
raise Error unless result == 7273
