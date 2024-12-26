// https://projecteuler.net/problem=40
export function compute(): number {
  const s = generateChampernowneConstant();

  let result = 1;
  for (let i = 1; i <= 1_000_000; i *= 10) {
    const c = s.charAt(i - 1);
    const j = Number.parseInt(c, 10);
    result *= j;
  }

  return result;
}

function generateChampernowneConstant(): string {
  const sb: string[] = [];

  for (let i = 1; sb.join('').length < 1_000_000; i++) {
    sb.push(i.toString());
  }

  return sb.join('');
}
