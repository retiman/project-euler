// Computes the smallest positive integer x such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
//
// See {@link https://projecteuler.net/problem=52}
export default function compute() {
  let x = 1;

  while (true) {
    const s = sort(x);
    const isValid = [2, 3, 4, 5, 6].every(m => {
      return sort(x * m) === s;
    });

    if (isValid) {
      return x;
    }

    x++;
  }
}

function sort(x: number): string {
  return x.toString().split('').sort().join('');
}
