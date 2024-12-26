import primes from './core/primes';

// Computes the nth prime number.
//
// @remarks
// Cheats.  Just uses a precomputed list of prime numbers.
//
// See {@link https://projecteuler.net/problem=7}.
export function compute(n: number) {
  return primes()[n - 1];
}
