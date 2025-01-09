import _ from 'lodash';
import sigma from './core/sigma';

// Computes the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
//
// See {@link https://projecteuler.net/problem=23}
export default function compute(limit: number) {
  const abundants = _.range(1, limit + 1).filter(n => sigma(n) - n > n);
  const numbers = _.range(0, limit + 1);

  for (let i = 0; i < abundants.length; i++) {
    for (let j = i; j < abundants.length; j++) {
      const sum = abundants[i] + abundants[j];
      if (sum <= limit) {
        numbers[sum] = 0;
      } else {
        break;
      }
    }
  }

  return numbers.reduce((a, b) => a + b, 0);
}
