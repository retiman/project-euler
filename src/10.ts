import primes from './core/primes';

// Computes the sum of all the prime numbers below the given limit.
//
// See {@link https://projecteuler.net/problem=10}.
export default function compute(limit: number) {
  return primes()
    .filter(p => p < limit)
    .reduce((a, b) => a + b, 0);
}
