// Computes b ** e modulo m.
//
// @remarks
// Uses the left-to-right binary method for modular exponentiation.
//
// See {@link https://en.wikipedia.org/wiki/Modular_exponentiation}.
// See {@link https://en.wikipedia.org/wiki/Exponentiation_by_squaring}.
export default function mexpt(b: number, e: number, m: number): number {
  let a = 1;

  while (e > 0) {
    if (e & 1) {
      a = (a * b) % m;
    }

    b = (b * b) % m;
    e >>= 1;
  }

  return a;
}
