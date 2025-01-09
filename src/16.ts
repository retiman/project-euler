import _ from 'lodash';

// Computes the sum of the digits of the given number raised to the given power.
//
// See {@link https://projecteuler.net/problem=16}.
export default function compute(k: number, e: number) {
  const s = BigInt(Math.pow(k, e)).toString();
  return s.split('').reduce((a, b) => a + _.toNumber(b), 0);
}
