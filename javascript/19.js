// time js -f 19.js
// 171
// 0.01user 0.00system 0:00.02elapsed 100%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+649minor)pagefaults 0swaps

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
