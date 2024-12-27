// Computes the Fibonacci numbers up to the given limit.
//
// @remarks
// Uses an iterative algorithm, does not memoize the results, and is not suitable for generating them.
export default function fibs(limit: number): number[] {
  if (limit < 1) {
    return [];
  }

  if (limit === 1) {
    return [0];
  }

  const fibs: number[] = [0, 1];

  while (true) {
    const next = fibs[fibs.length - 1] + fibs[fibs.length - 2];
    if (next >= limit) {
      break;
    }

    fibs.push(next);
  }

  return fibs;
}
