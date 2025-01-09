import _ from 'lodash';
import sigma from './core/sigma';

// Computes the sum of all amicable numbers under `limit`.
//
// See {@link https://projecteuler.net/problem=21}
export default function compute(limit: number) {
  let sum = 0;

  for (const a of _.range(2, limit + 1)) {
    const b = sigma(a) - a;
    if (a > b && sigma(b) - b === a) {
      sum += a + b;
    }
  }

  return sum;
}
