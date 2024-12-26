export function compute(limit: number) {
  let result = 0;

  const amax = Math.floor(limit / 3);
  for (let a = 1; a <= amax; a++) {
    const bmax = Math.floor((limit - a) / 2);
    for (let b = a + 1; b < bmax; b++) {
      const c = limit - a - b;

      if (a * a + b * b === c * c) {
        result = a * b * c;
        break;
      }
    }
  }

  return result;
}
