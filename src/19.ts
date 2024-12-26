// See https://projecteuler.net/problem=19
export function compute() {
  // Days per month, considering February as 28 days
  const daysPerMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

  // Function to calculate days in a month, accounting for leap years
  function daysInMonth(month: number, year: number): number {
    let days = daysPerMonth[month];
    if (month === 1 && year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0)) {
      days += 1;
    }
    return days;
  }

  let days = 2; // Start on a Tuesday (day 2)

  // Calculate number of Sundays on the first of the month from 1901 to 2000
  let result = 0;
  for (let year = 1901; year <= 2000; year++) {
    for (let month = 0; month < 12; month++) {
      if (days % 7 === 0) {
        result += 1;
      }

      days += daysInMonth(month, year);
    }
  }

  return result;
}
