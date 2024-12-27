import _ from 'lodash';
import primes from './core/primes';

// Finds the least value of n for which the remainder described in the problem first exceeds 1e10.
//
// See {@link https://projecteuler.net/problem=123}.
export default function compute(limit: number) {
  return find(primes(), limit);
}

function r(p: number, n: number) {
  if (n % 2 === 0) {
    return 2;
  }

  return p * n * 2;
}

function find(ps: number[], limit: number): number {
  let n = 1;

  for (let i = 0; i < ps.length; i++) {
    const p = ps[i];
    if (r(p, n) >= limit) {
      return n;
    }

    n++;
  }

  throw new Error('not enough primes');
}
