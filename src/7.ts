import { primes } from './core/number-theory';

// Computes the nth prime number.
//
// @remarks
// Cheats.  Just uses a precomputed list of prime numbers.
//
// See https://projecteuler.net/problem=7
export function compute(n: number) {
  return primes()[n - 1];
}
