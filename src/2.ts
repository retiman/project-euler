import fibs from './core/fibs';

// Computes the sum of all the even Fibonacci numbers below the given limit.
//
// See {@link https://projecteuler.net/problem=2}.
export default function compute(limit: number) {
  return fibs(limit)
    .filter(n => n % 2 === 0)
    .reduce((a, b) => a + b, 0);
}
