export function compute(limit: number) {
  let max = 0;
  let result = 0;

  for (let i = 1; i < limit; i++) {
    const current = collatz(i);
    if (current > max) {
      max = current;
      result = i;
    }
  }

  return result;
}

function collatz(n: number): number {
  const memo = new Map<number, number>();

  function len(n: number): number {
    if (n === 1) {
      return 0;
    }

    if (memo.has(n)) {
      return memo.get(n)!;
    }

    const next = n % 2 === 0 ? n / 2 : 3 * n + 1;
    const result = 1 + len(next);

    memo.set(n, result);
    return result;
  }

  return len(n);
}
