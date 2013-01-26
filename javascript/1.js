function range(begin, end) {
  for (let i = begin; i < end; i++) yield i;
}

let xs = range(1, 1000);
let result = [x for each (x in xs) if (x % 3 === 0 || x % 5 === 0)].
  reduce(function (a, b) {
    return a + b;
  });
print(result);
