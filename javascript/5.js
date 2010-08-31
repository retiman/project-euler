// time js -f 5.js
// 232792560
// 0.00user 0.00system 0:00.00elapsed 114%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+561minor)pagefaults 0swaps

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
