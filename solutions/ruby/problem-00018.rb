#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00018.rb 
# 1074
#
# real  0m0.022s
# user  0m0.020s
# sys 0m0.004s
data = <<EOF
75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
EOF
data = data.lines.map { |l| l.strip }.select { |l| l != "" }
data = data.map { |l| l.split(" ").map { |s| s.to_i } }

(data.length - 2).step(0, -1).each do |i|
  (0..(data[i].length-1)).each do |j|
    left = data[i+1][j]
    right = data[i+1][j+1]
    data[i][j] += [left, right].max
  end
end

puts data[0][0]
