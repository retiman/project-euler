import _ from 'lodash';

// Computes the sum of all the multiples of 3 or 5 below the given limit.
//
// See https://projecteuler.net/problem=1
export function compute(limit: number) {
  return _.range(limit)
    .filter(n => n % 3 === 0 || n % 5 === 0)
    .reduce((a, b) => a + b, 0);
}
