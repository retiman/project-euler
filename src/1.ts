import _ from 'lodash';

// See https://projecteuler.net/problem=1
export function compute(limit: number) {
  return _.range(limit)
    .filter(n => n % 3 === 0 || n % 5 === 0)
    .reduce((a, b) => a + b, 0);
}
