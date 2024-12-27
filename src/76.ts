// Computes the number of ways `target` can be written as a sum of at least two positive integers.
//
// See {@link https://projecteuler.net/problem=76}
export default function compute(target: number) {
  return partition(1, target) - 1;
}

const map = new Map<string, number>();

function partition(k: number, n: number): number {
  if (k > n) {
    return 0;
  }

  if (k === n) {
    return 1;
  }

  const key = `${k},${n}`;
  if (map.has(key)) {
    return map.get(key)!;
  }

  const value = partition(k + 1, n) + partition(k, n - k);
  map.set(key, value);
  return value;
}
