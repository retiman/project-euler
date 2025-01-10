import slurp from "./core/slurp"

// Computes the maximum path sum from the top to the bottom of a triangle.
//
// See {@link https://projecteuler.net/problem=67}
export default function compute() {
  const triangle = slurp('67.txt')
    .trim()
    .split('\n')
    .map(row => row.trim().split(' ').map(Number));

  for (let i = triangle.length - 2; i >= 0; i--) {
    for (let j = 0; j < triangle[i].length; j++) {
      triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
    }
  }

  return triangle[0][0];
}
