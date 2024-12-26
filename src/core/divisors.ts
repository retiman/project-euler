const memo = new Map<number, number[]>();

// Computes the divisors of a given number.
//
// @remarks
// Uses a simple algorithm of trial division and memoizes the results.
//
// @returns The divisors in ascending order.
export default function divisors(n: number): number[] {
  if (memo.has(n)) {
    return memo.get(n)!;
  }

  const set = new Set<number>();
  const limit = Math.floor(Math.sqrt(n));

  // We only need to go up to the square root of the number to find all of its divisors; divisors always occur in pairs,
  // and you can't get divisors larger than the square root.
  for (let i = 1; i <= limit; i++) {
    if (n % i === 0) {
      set.add(i);
      set.add(n / i);
    }
  }

  const ds = Array.from(set);
  ds.sort((a, b) => a - b);

  memo.set(n, ds);
  return ds;
}
