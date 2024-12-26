export function atoi(c: string): number {
  return parseInt(c, 10 /* radix */);
}

export function itoa(n: number): string {
  return String.fromCharCode(48 + n);
}

export function range(n: number): number[] {
  return Array.from({ length: n + 1 }, (_, i) => i);
}
