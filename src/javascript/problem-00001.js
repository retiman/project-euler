// [minhuang@mocha:javascript(master)]$ time js -f problem-00001.js
// 233168
//
// real 0m0.009s
// user 0m0.008s
// sys  0m0.004s
function range(begin, end) {
  for (let i = begin; i < end; i++) yield i;
}

let xs = range(1, 1000);
let result = [x for each (x in xs) if (x % 3 === 0 || x % 5 === 0)].
  reduce(function (a, b) {
    return a + b;
  });
print(result);
