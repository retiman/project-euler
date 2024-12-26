// Compute the product of the Pythagorean triplet for which a + b + c = target.
//
// See https://projecteuler.net/problem=9
export default function compute(target: number) {
  let result = 0;

  // Limit search space for a; since b and c are greater than a, the maximum value for a is 1/3 of the target.
  const amax = Math.floor(target / 3);
  for (let a = 1; a <= amax; a++) {
    // Limit search space for b; since c is greater than b, the maximum value for b is half the remaining value.
    const bmax = Math.floor((target - a) / 2);
    for (let b = a + 1; b < bmax; b++) {
      const c = target - a - b;

      if (a * a + b * b === c * c) {
        result = a * b * c;
        break;
      }
    }
  }

  return result;
}
