// [minhuang@mocha:javascript(master*)]$ time js -f problem-00005.js
// 232792560
//
// real 0m0.008s
// user 0m0.008s
// sys  0m0.004s
function range(begin, end) {
  for (let i = begin; i < end; i++) yield i;
}

function gcd(a, b) {
  if (b === 0)
    return a;
  return gcd(b, a % b);
}

function lcm(a, b) {
  return a * (b / gcd(a, b));
}

let result = [i for each (i in range(1, 20))].reduceRight(lcm);
print(result);
