// Computes the number that produces the longest Collatz chain under a given limit.
//
// See {@link https://projecteuler.net/problem=14}.
const memo = new Map<number, number>();

function collatzLength(n: number): number {
  if (n === 1) {
    return 0;
  }

  if (memo.has(n)) {
    return memo.get(n)!;
  }

  const next = n % 2 === 0 ? n / 2 : 3 * n + 1;
  const result = 1 + collatzLength(next);

  memo.set(n, result);
  return result;
}

export default function compute(limit: number) {
  let max = 0;
  let result = 0;

  for (let i = 1; i < limit; i++) {
    const current = collatzLength(i);
    if (current > max) {
      max = current;
      result = i;
    }
  }

  return result;
}
