import _ from 'lodash';

// Computes the sum of the maximum remainders of (a - 1)^n + (a + 1)^n for 3 ≤ a ≤ 1000.
//
// See {@link https://projecteuler.net/problem=120}.
export default function compute(): number {
  return _.range(3, 1001)
    .map(f)
    .reduce((a, b) => a + b, 0);
}

function f(a: number) {
  function g(n: number) {
    if (n === 1) {
      return 2 * a;
    }

    if (n % 2 === 0) {
      return 2;
    }

    return 2 * n * a;
  }

  return _.range(1, 2 * a + 1)
    .map(g)
    .map(n => n % (a * a))
    .reduce((a, b) => Math.max(a, b), 0);
}
