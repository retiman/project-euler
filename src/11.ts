import _ from 'lodash';
import { read } from './core';

// See https://projecteuler.net/problem=11
export function compute() {
  const m = read('11.txt').map(line =>
    line
      .split(' ')
      .map(s => s.trim())
      .map(_.toNumber)
  );

  const rows = m.length;
  const columns = m[0].length;
  let result = 0;
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      result = Math.max(result, right(m, i, j), up(m, i, j), upRight(m, i, j), downRight(m, i, j));
    }
  }

  return result;
}

function product(m: number[][], i: number, j: number, di: number, dj: number): number {
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

function right(m: number[][], i: number, j: number): number {
  return product(m, i, j, 0, 1);
}

function up(m: number[][], i: number, j: number): number {
  return product(m, i, j, -1, 0);
}

function upRight(m: number[][], i: number, j: number): number {
  return product(m, i, j, -1, 1);
}

function downRight(m: number[][], i: number, j: number): number {
  return product(m, i, j, 1, 1);
}
