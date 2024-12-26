import { primes } from './core/primes';

// See https://projecteuler.net/problem=10
export function compute(limit: number) {
  return primes()
    .filter(_ => _ < limit)
    .reduce((sum, _) => sum + _, 0);
}
