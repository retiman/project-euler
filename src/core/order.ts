import gcd from './gcd';
import divisors from './divisors';
import mexpt from './modular-exponentiation';
import totient from './totient';

const memo = new Map<string, number>();

// Computes the multiplicative order of b modulo m.
//
// @remarks
// The multiplicative order of b modulo m is the smallest positive integer d such that b ** d ≡ 1 (mod m).
//
// See {@link https://en.wikipedia.org/wiki/Multiplicative_order}.
export default function ord(b: number, m: number): number {
  if (gcd(b, m) !== 1) {
    throw new Error('b and m must be coprime');
  }

  // We'd like to memoize based on both b and m, so we concatenate them into a single string.
  const key = `${b},${m}`;
  if (memo.has(key)) {
    return memo.get(key)!;
  }

  const phi = totient(m);
  const ds = divisors(phi);

  for (const d of ds) {
    if (mexpt(b, d, m) === 1) {
      memo.set(key, d);
      return d;
    }
  }

  // This shouldn't happen if b and m are coprime.
  throw new Error('could not compute ord(b, m)');
}
