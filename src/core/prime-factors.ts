import divisors from './divisors';

const memo = new Map<number, number[]>();

// Computes the prime factors of a given number.
//
// @remarks
// Checks all divisors for the number and returns the ones that are prime.  Memoizes the results.
//
// @returns The prime factors in ascending order.
export default function primeFactors(n: number): number[] {
  if (memo.has(n)) {
    return memo.get(n)!;
  }

  const ds = divisors(n);
  const primes: number[] = [];

  for (const d of ds) {
    if (d > 1 && divisors(d).length === 2) {
      primes.push(d);
    }
  }

  memo.set(n, primes);
  return primes;
}
