#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00022.rb 
# 871198282
#
# real  0m1.942s
# user  0m1.928s
# sys 0m0.008s
def score(name)
  scores = Hash[('A'..'Z').zip(1..26)]
  name.chars.map { |c| scores[c] }.inject(&:+)
end

file = File.new("../../data/problem-00022.txt")
data = file.gets.gsub("\"", "").split(",") # All one line in file
file.close

result = data.each_index.
              zip(data.sort).
              map { |t| (t.first+1) * score(t.last) }.
              inject(&:+)
puts result
