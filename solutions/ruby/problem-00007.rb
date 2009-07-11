#!/usr/bin/env ruby
# [minhuang@mocha:ruby]$ time ruby problem-00007.rb 
# 104743
#
# real  3m23.351s
# user  3m9.336s
# sys 0m10.617s
#
# OMG! 3 minutes?!
require 'mathn'
result = Prime.new.take(10001).last
puts result
