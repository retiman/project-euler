import java.util.Calendar
import java.util.Calendar._

var cal = Calendar.getInstance
var sundays = 0
(1901 to 2000).foreach(year => {
  (0 to 11).foreach(month => {
    cal.set(year, month, 1) 
    if (cal.get(DAY_OF_WEEK) == SUNDAY)
      sundays += 1
  })
})
println(sundays)
