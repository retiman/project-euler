/*
[minhuang@mocha:scala]$ time scala problem-00019.scala 
171

real  0m1.463s
user  0m0.308s
sys 0m0.080s
*/
import java.util.Calendar
import java.util.Calendar._

var cal = Calendar.getInstance
var sundays = 0

for (year <- 1901 to 2000;
     month <- 0 to 11) {
  cal.set(year, month, 1)
  if (cal.get(DAY_OF_WEEK) == SUNDAY) sundays += 1
}

println(sundays)
