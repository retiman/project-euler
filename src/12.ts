// Computes the value of the first triangle number to have over the given number of divisors.
//
// See {@link https://projecteuler.net/problem=12}.
import tau from './core/tau';

export default function compute(limit: number): number {
  let n = 0;
  let i = 1;

  while (tau(n) <= limit) {
    n += i;
    i += 1;
  }

  return n;
}
