import fs from 'fs';
import path from 'path';
import _ from 'lodash';

const memo = {
  divisors: new Map<number, number[]>(),
  factorial: new Map<number, bigint>(),
  ord: new Map<string, number>(),
  primeFactors: new Map<number, number[]>(),
  totient: new Map<number, number>()
};

export function countDigits(n: number): number {
  if (n === 0) {
    return 1;
  }

  return Math.floor(Math.log10(Math.abs(n))) + 1;
}

export function divisors(n: number): number[] {
  if (memo.divisors.has(n)) {
    return memo.divisors.get(n)!;
  }

  const ds = new Set<number>();
  const t = Math.floor(Math.sqrt(n));

  for (let i = 1; i <= t; i++) {
    if (n % i === 0) {
      ds.add(i);
      ds.add(n / i);
    }
  }

  const result = Array.from(ds);
  result.sort((a, b) => a - b);

  memo.divisors.set(n, result);
  return result;
}

export function factorial(n: number): bigint {
  if (n < 0) {
    throw new Error('n must be non-negative');
  }

  if (n === 0 || n === 1) {
    return 1n;
  }

  if (memo.factorial.has(n)) {
    return memo.factorial.get(n)!;
  }

  let product = 2n;
  for (let i = 3n; i <= n; i++) {
    product *= i;
  }

  memo.factorial.set(n, product);
  return product;
}

export function fibs(limit: number): number[] {
  const fibs: number[] = [0, 1];

  while (true) {
    const next = fibs[fibs.length - 1] + fibs[fibs.length - 2];
    if (next >= limit) {
      break;
    }

    fibs.push(next);
  }

  return fibs;
}

export function gcd(m: number, n: number): number {
  while (n !== 0) {
    [m, n] = [n, m % n];
  }

  return m;
}

export function isPrime(n: number): boolean {
  if (n <= 1) {
    return false;
  }

  if (n === 2) {
    return true;
  }

  return divisors(n).length === 2;
}

export function lcm(m: number, n: number): number {
  return Math.abs(m * n) / gcd(m, n);
}

export function mexpt(b: number, e: number, m: number): number {
  let a = 1;

  while (e > 0) {
    if (e & 1) {
      a = (a * b) % m;
    }

    b = (b * b) % m;
    e >>= 1;
  }

  return a;
}

export function mtetration(b: number, e: number, m: number): number {
  function f(b: number, e: number, m: number): number {
    const o = ord(b, m);
    const t = mtetration(b, e - 1, o);
    return mexpt(b, t, m);
  }

  function g(b: number, e: number, m: number, d: number): number {
    const n = Math.floor(m / d);
    const t = mtetration(b, e, n);
    const i = mexpt(b, totient(n) - 1, n);
    const u = (t * i) % n;
    return (b * u) % m;
  }

  if (m === 1) {
    return 0;
  }

  if (e === 1) {
    return b % m;
  }

  const d = gcd(b, m);
  if (d === 1) {
    return f(b, e, m);
  }

  if (d === m) {
    return 0;
  }

  return g(b, e, m, d);
}

export function ord(b: number, m: number): number {
  if (gcd(b, m) !== 1) {
    throw new Error('b and m must be coprime');
  }

  const key = `${b},${m}`;
  if (memo.ord.has(key)) {
    return memo.ord.get(key)!;
  }

  const phi = totient(m);
  const ds = divisors(phi);

  for (const d of ds) {
    if (mexpt(b, d, m) === 1) {
      memo.ord.set(key, d);
      return d;
    }
  }

  throw new Error('could not compute ord(b, m)');
}

export function primes(): number[] {
  return fs.readFileSync(path.join('data', 'primes.txt')).toString().split('\n').map(_.toNumber);
}

export function primeFactors(n: number): number[] {
  if (memo.primeFactors.has(n)) {
    return memo.primeFactors.get(n)!;
  }

  const ds = divisors(n);
  const primes: number[] = [];

  for (const d of ds) {
    if (d > 1 && divisors(d).length === 2) {
      primes.push(d);
    }
  }

  memo.primeFactors.set(n, primes);
  return primes;
}

export function sigma(n: number): number {
  return divisors(n).reduce((a, b) => a + b, 0);
}

export function tau(n: number): number {
  return divisors(n).length;
}

export function totient(n: number): number {
  if (memo.totient.has(n)) {
    return memo.totient.get(n)!;
  }

  if (n === 1) {
    return 0;
  }

  const phi = Math.floor(
    primeFactors(n)
      .map(p => 1 - 1 / p)
      .reduce((a, b) => a * b, n)
  );

  memo.totient.set(n, phi);
  return phi;
}
