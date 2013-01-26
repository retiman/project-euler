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
