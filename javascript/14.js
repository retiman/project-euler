// time js -f 14.js
// 837799
// 10.81user 0.55system 0:12.18elapsed 93%CPU (0avgtext+0avgdata 0maxresident)k
// 1712inputs+0outputs (11major+46887minor)pagefaults 0swaps

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
