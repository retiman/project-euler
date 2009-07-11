#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00007.rb 
# 104743
#
# real    0m1.090s
# user    0m1.032s
# sys     0m0.028s
require 'mathn'
puts Prime.new.take(10001).last
