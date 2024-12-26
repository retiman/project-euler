import primeFactors from './core/prime-factors';

// Computes the largest prime factor of a given number.
//
// See https://projecteuler.net/problem=3
export default function compute(n: number) {
  return Math.max(...primeFactors(n));
}
