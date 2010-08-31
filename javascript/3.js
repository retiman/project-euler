// time js -f 3.js
// 6857
// 0.08user 0.00system 0:00.10elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+1610minor)pagefaults 0swaps

function factor(n) {
  if (n % 2 === 0)
    return [2, n / 2];
  let a = Math.ceil(Math.sqrt(n));
  let b = a * a - n;
  let s = Math.sqrt(b);
  while (s !== Math.round(s)) {
    a += 1;
    b = a * a - n;
    s = Math.sqrt(b);
  }
  return [a - s, a + s];
}

function primeFactorization(n) {
  let factors = factor(n);
  if (factors[0] === 1)
    return [factors[1]];
  if (factors[1] === 1)
    return [factors[0]];
  return factors.
    filter(function (i) {
      return i !== 1;
    }).
    map(function (i) {
      return primeFactorization(i);
    }).
    reduce(function (a, b) {
      return a.concat(b);
    });
}

let result = Math.max.apply(this, primeFactorization(600851475143));
print(result);
