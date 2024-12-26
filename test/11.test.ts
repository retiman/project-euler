import { toNumber } from 'lodash';
import { read } from '../src/core';

// See https://projecteuler.net/problem=11
describe('summation of primes', () => {
  function compute() {
    const m = read('11.txt').map(line =>
      line
        .split(' ')
        .map(_ => _.trim())
        .map(toNumber)
    );

    function product(i: number, j: number, di: number, dj: number): number {
      try {
        let p = 1;

        for (let k = 0; k < 4; k++) {
          p *= m[i + k * di][j + k * dj];
        }

        return Number.isNaN(p) ? 0 : p;
      } catch {
        return 0;
      }
    }

    function right(i: number, j: number): number {
      return product(i, j, 0, 1);
    }

    function up(i: number, j: number): number {
      return product(i, j, -1, 0);
    }

    function upRight(i: number, j: number): number {
      return product(i, j, -1, 1);
    }

    function downRight(i: number, j: number): number {
      return product(i, j, 1, 1);
    }

    const rows = m.length;
    const columns = m[0].length;
    let result = 0;
    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < columns; j++) {
        result = Math.max(result, right(i, j), up(i, j), upRight(i, j), downRight(i, j));
      }
    }

    return result;
  }

  test('problem 11', async () => {
    expect(compute()).toBe(70600674);
  });
});
