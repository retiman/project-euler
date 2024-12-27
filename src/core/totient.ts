import primeFactors from './prime-factors';

const memo = new Map<number, number>();

// Computes the totient of a given number.
//
// @remarks
// The totient of a number n is the number of positive integers less than n that are coprime to n.  We can compute this
// directly using the number's distinct prime factors.
//
// See {@link https://en.wikipedia.org/wiki/Euler's_totient_function}.
export default function totient(n: number): number {
  if (memo.has(n)) {
    return memo.get(n)!;
  }

  if (n === 1) {
    return 0;
  }

  const phi = Math.floor(
    primeFactors(n)
      .map(p => 1 - 1 / p)
      .reduce((a, b) => a * b, n)
  );

  memo.set(n, phi);
  return phi;
}
