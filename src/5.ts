import _ from 'lodash';
import lcm from './core/lcm';

// Computes the smallest number that can be divided by each of the numbers from 1 to n without any remainder.
//
// See {@link https://projecteuler.net/problem=5}.
export default function compute(n: number) {
  return _.range(1, n + 1).reduce(lcm, 1);
}
