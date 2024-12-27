import primes from './core/primes';

// Computes the value of n for which n/φ(n) is maximized.
//
// @remarks
// It's not necessary to actually compute the totient function for each number.  The ratio will be largest with the
// denominator is as small as possible.  This will occur when n has many prime divisors.
//
// See {@link docs/problem-69.md}.
// See {@link https://projecteuler.net/problem=69}.
export default function compute(limit: number) {
  let ps = primes();
  let acc = 1;

  while (ps.length > 0) {
    const n = acc * ps[0];
    if (n > limit) {
      return acc;
    }

    acc = n;
    ps = ps.slice(1);
  }

  throw new Error('not enough primes');
}
