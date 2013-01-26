require 'date'
sundays = 0
(1901..2000).each do |year|
  (1..12).each do |month|
    d = Date.new(year, month, 1)
    sundays += 1 if d.cwday == 7 # Sunday
  end
end
puts sundays
