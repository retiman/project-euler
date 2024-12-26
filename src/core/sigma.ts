import divisors from './divisors';

// Computes the sum of the divisors of a given number.
//
// See {@link https://en.wikipedia.org/wiki/Divisor_function}
export default function sigma(n: number): number {
  return divisors(n).reduce((a, b) => a + b, 0);
}
