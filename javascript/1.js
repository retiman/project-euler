// time js -f 1.js
// 233168
// 0.00user 0.00system 0:00.00elapsed 160%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+563minor)pagefaults 0swaps

function range(begin, end) {
  for (let i = begin; i < end; i++) yield i;
}

let xs = range(1, 1000);
let result = [x for each (x in xs) if (x % 3 === 0 || x % 5 === 0)].
  reduce(function (a, b) {
    return a + b;
  });
print(result);
