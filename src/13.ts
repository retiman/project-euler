import _ from 'lodash';
import slurp from './core/slurp';

// Compute the first ten digits of the sum of the one-hundred 50-digit numbers defined by `13.txt`.
//
// See {@link https://projecteuler.net/problem=13}.
export default function compute() {
  const numbers = slurp('13.txt').split('\n').map(BigInt);
  const sum = numbers.reduce((a, b) => a + b, 0n);
  const text = sum.toString().slice(0, 10);
  return _.toNumber(text);
}
