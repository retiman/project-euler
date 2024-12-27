import _ from 'lodash';
import combinations from './core/combinations';

// Computes the number distinct values of (n choose r) for 1 ≤ n ≤ limit that are greater than 1_000_000.
//
// See {@link https://projecteuler.net/problem=53}.
export default function compute(limit: number) {
  let count = 0;

  for (const n of _.range(1, limit + 1)) {
    for (const r of _.range(1, n - 1)) {
      const c = combinations(n, r);
      if (c > 1_000_000) {
        count++;
      }
    }
  }

  return count;
}
