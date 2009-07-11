#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00019.rb 
# 171
#
# real  0m0.174s
# user  0m0.160s
# sys 0m0.000s
require 'date'

sundays = 0
(1901..2000).each do |year|
  (1..12).each do |month|
    d = Date.new(year, month, 1)
    sundays += 1 if d.cwday == 7 # Sunday
  end
end

puts sundays
