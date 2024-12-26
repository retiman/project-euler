import divisors from './divisors';

// Compute the number of divisors of a number.
//
// @remarks
// Includes the number itself.
//
// See {@link https://en.wikipedia.org/wiki/Tau_function}.
// See {@link https://en.wikipedia.org/wiki/Divisor_function}.
export default function tau(n: number): number {
  return divisors(n).length;
}
