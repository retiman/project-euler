import gcd from './gcd';
import mexpt from './modular-exponentiation';
import ord from './order';
import totient from './totient';

// Computes the modular tetration of b to the power of e modulo m.
//
// See {@link https://en.wikipedia.org/wiki/Tetration}.
export default function mtetn(b: number, e: number, m: number): number {
  function f(b: number, e: number, m: number): number {
    const o = ord(b, m);
    const t = mtetn(b, e - 1, o);
    return mexpt(b, t, m);
  }

  function g(b: number, e: number, m: number, d: number): number {
    const n = Math.floor(m / d);
    const t = mtetn(b, e, n);
    const i = mexpt(b, totient(n) - 1, n);
    const u = (t * i) % n;
    return (b * u) % m;
  }

  if (m === 1) {
    return 0;
  }

  if (e === 1) {
    return b % m;
  }

  const d = gcd(b, m);
  if (d === 1) {
    return f(b, e, m);
  }

  if (d === m) {
    return 0;
  }

  return g(b, e, m, d);
}
