// [minhuang@mocha:javascript(master*)]$ time js -f problem-00014.js
// 837799
//
// real 0m7.958s
// user 0m7.672s
// sys  0m0.184s
let map = [1, 1];
let limit = 1000000;

function range(begin, end) {
  for (let i = begin; i < end; i++) yield i;
}

function collatz(n) {
  let v = map[n];
  if (v !== undefined)
    return v;
  if (n % 2 === 0)
    v = 1 + collatz(n / 2);
  else
    v = 1 + collatz(3 * n + 1);
  map[n] = v;
  return v;
}

let result = [ [i, collatz(i)] for each (i in range(1, limit)) ].
  reduce(function (a, b) {
    if (a[1] > b[1])
      return a;
    else
      return b;
  })[0];
print(result);
