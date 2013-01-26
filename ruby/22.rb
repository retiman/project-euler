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
