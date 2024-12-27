// Computes the number of combinations of n items taken r at a time.
//
// See {@link https://en.wikipedia.org/wiki/Combination}.
// See {@link https://en.wikipedia.org/wiki/Binomial_coefficient}.
export default function combinations(n: number, r: number): number {
  if (r > n || n < 0 || r < 0) {
    return 0;
  }

  // Note that C(n, r) = C(n, n - r).
  if (r > n - r) {
    r = n - r;
  }

  let result = 1;
  for (let i = 0; i < r; i++) {
    result *= n - i;
    result /= i + 1;
  }

  return result;
}
