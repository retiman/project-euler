import _ from 'lodash';
import slurp from './core/slurp';

// Computes the greatest product of 4 adjacent numbers in the same direction in the grid defined by `11.txt`.
//
// See https://projecteuler.net/problem=11
export default function compute() {
  const m = slurp('11.txt')
    .trim()
    .split('\n')
    .map(line => {
      return line
        .split(' ')
        .map(s => s.trim())
        .map(_.toNumber);
    });

  const rows = m.length;
  const columns = m[0].length;
  let result = 0;
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      result = Math.max(
        result,
        product(m, i, j, Direction.UP),
        product(m, i, j, Direction.RIGHT),
        product(m, i, j, Direction.UP_RIGHT),
        product(m, i, j, Direction.DOWN_RIGHT)
      );
    }
  }

  return result;
}

const Direction = {
  UP: [-1, 0],
  RIGHT: [0, 1],
  UP_RIGHT: [-1, 1],
  DOWN_RIGHT: [1, 1]
} as const;

// Safely compute the product of the four elements in the matrix starting at position (i, j) and moving in the direction
// indicated by (di, dj).
//
// @remarks
// If the product is NaN or if we get an out-of-bounds error, we return 0.
function product(m: number[][], i: number, j: number, direction: readonly [number, number]): number {
  try {
    const [di, dj] = direction;
    let p = 1;

    for (let k = 0; k < 4; k++) {
      p *= m[i + k * di][j + k * dj];
    }

    if (Number.isNaN(p)) {
      return 0;
    }

    return p;
  } catch {
    return 0;
  }
}
