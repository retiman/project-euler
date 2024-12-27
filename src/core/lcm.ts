import gcd from './gcd';

// Computes the least common multiple of two numbers.
//
// See {@link https://en.wikipedia.org/wiki/Least_common_multiple}.
export default function lcm(m: number, n: number): number {
  return Math.abs(m * n) / gcd(m, n);
}
