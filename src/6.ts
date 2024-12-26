import _ from 'lodash';

// See https://projecteuler.net/problem=6
export function compute(limit: number) {
  const a = _.range(limit + 1)
    .map(n => n ** 2)
    .reduce((a, b) => a + b, 0);
  const b = _.range(limit + 1).reduce((a, b) => a + b, 0) ** 2;
  return b - a;
}
