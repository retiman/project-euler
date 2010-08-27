// JAVA_OPTS="-Xmx1024M" time scala -deprecation 19.scala
// 171
// 0.73user 0.02system 0:01.66elapsed 45%CPU (0avgtext+0avgdata 0maxresident)k
// 240inputs+64outputs (1major+15964minor)pagefaults 0swaps

import java.util.Calendar
import java.util.Calendar._

var cal = Calendar.getInstance
var sundays = 0

for (
  year <- 1901 to 2000;
  month <- 0 to 11
) {
  cal.set(year, month, 1)
  if (cal.get(DAY_OF_WEEK) == SUNDAY) sundays += 1
}

println(sundays)
