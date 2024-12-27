// Computes b ** e modulo m.
//
// @remarks
// Works with bigints.
//
// See {@link https://en.wikipedia.org/wiki/Modular_exponentiation}.
// See {@link https://en.wikipedia.org/wiki/Exponentiation_by_squaring}.
export default function mexpt(b: bigint, e: bigint, m: bigint): bigint {
  let a = 1n;

  while (e > 0) {
    if (e % 2n === 1n) {
      a = (a * b) % m;
    }

    b = (b * b) % m;
    e /= 2n;
  }

  return a;
}
