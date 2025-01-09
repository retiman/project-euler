// Computes the largest prime factor of a given number.
//
// See {@link https://projecteuler.net/problem=3}.
import primeFactors from './core/prime-factors';

export default function compute(n: number) {
  return Math.max(...primeFactors(n));
}
