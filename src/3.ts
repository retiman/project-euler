import { primeFactors } from './core/number-theory';

// Computes the largest prime factor of a given number.
//
// See https://projecteuler.net/problem=3
export function compute(n: number) {
  return Math.max(...primeFactors(n));
}
