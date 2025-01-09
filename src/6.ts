// Computes the difference between the sum of the squares of the first n natural numbers and the square of the sum of
// the first n natural numbers.
//
// See {@link https://projecteuler.net/problem=6}.
import _ from 'lodash';

export default function compute(limit: number) {
  const a = _.range(limit + 1)
    .map(n => n ** 2)
    .reduce((a, b) => a + b, 0);
  const b = _.range(limit + 1).reduce((a, b) => a + b, 0) ** 2;
  return b - a;
}
