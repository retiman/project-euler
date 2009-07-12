#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00067.rb 
# 7273
#
# real  0m0.129s
# user  0m0.048s
# sys 0m0.004s
data = []
file = File.new("../../data/problem-00067.txt")
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
