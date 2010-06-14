// [minhuang@mocha:javascript(master*)]$ time js -f problem-00019.js 
// 171
//
// real 0m0.041s
// user 0m0.024s
// sys  0m0.012s
function gen(a, b, c, d) {
  for (let i = a; i <= b; i++)
    for (let j = c; j <= d; j++)
      yield [i, j];
}

let sundays = 0;
let months = [
  [year, month] for each ([year, month] in gen(1901, 2000, 1, 12))
];
let result = months.filter(function (e) {
    let [year, month] = e;
    let d = new Date(year, month - 1, 1);
    return d.getDay() === 0;
  }).length;
print(result);
