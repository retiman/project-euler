// Computes the sum of the digits of the factorial of a given number.
//
// See {@link https://projecteuler.net/problem=20}.
import _ from 'lodash';
import factorial from './core/factorial';

export default function compute(limit: number) {
  const text = _.toString(factorial(limit));

  let sum = 0;
  for (let i = 0; i < text.length; i++) {
    sum += _.toNumber(text[i]);
  }

  return sum;
}
