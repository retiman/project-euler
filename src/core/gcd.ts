// Computes the greatest common divisor of two numbers.
//
// See {@link https://en.wikipedia.org/wiki/Greatest_common_divisor}.
export default function gcd(m: number, n: number): number {
  if (m < 0 || n < 0) {
    throw new Error('m and n must be non-negative.');
  }

  while (n !== 0) {
    [m, n] = [n, m % n];
  }

  return m;
}
