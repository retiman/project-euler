// Computes the factorial of a non-negative integer n.
//
// @remarks
// These numbers get big fast, so we return a bigint.
export default function factorial(n: number): bigint {
  if (n < 0) {
    throw new Error('n must be non-negative');
  }

  if (n === 0 || n === 1) {
    return 1n;
  }

  let product = 2n;
  for (let i = 3n; i <= n; i++) {
    product *= i;
  }

  return product;
}
