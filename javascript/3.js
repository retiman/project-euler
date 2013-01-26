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
