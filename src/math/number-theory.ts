import { range } from 'lodash';

const cache = {
  divisors: new Map<number, Set<number>>(),
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

export function divisors(n: number): Set<number> {
  if (cache.divisors.has(n)) {
    return cache.divisors.get(n)!;
  }

  const ds = new Set<number>();
  const t = Math.floor(Math.sqrt(n));

  for (let i = 1; i <= t; i++) {
    if (n % i === 0) {
      ds.add(i);
      ds.add(n / i);
    }
  }

  cache.divisors.set(n, ds);
  return ds;
}

export function factorial(n: number): number {
  if (n < 0) {
    throw new Error('n must be non-negative');
  }

  if (n === 0 || n === 1) {
    return 1;
  }

  return range(2, n + 1).reduce((acc, _) => acc * _, 1);
}

export function factorion(n: number): boolean {
  let sum = 0;
  let t = n;

  while (t > 0) {
    const digit = t % 10;
    sum += factorial(digit);
    t = Math.floor(t / 10);
  }

  return sum === n;
}

export function gcd(a: number, b: number): number {
  while (b !== 0) {
    [a, b] = [b, a % b];
  }

  return a;
}

export function isCoprime(m: number, n: number): boolean {
  return gcd(m, n) === 1;
}

export function isDivides(m: number, n: number): boolean {
  return n % m === 0;
}

export function isPrime(n: number): boolean {
  if (n <= 1) {
    return false;
  }

  if (n === 2) {
    return true;
  }

  return divisors(n).size === 2;
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
  if (!isCoprime(b, m)) {
    throw new Error('b and m must be coprime');
  }

  const key = `${b},${m}`;
  if (cache.ord.has(key)) {
    return cache.ord.get(key)!;
  }

  const phi = totient(m);
  const ds = Array.from(divisors(phi));

  ds.sort((a, b) => a - b);
  for (const d of ds) {
    if (mexpt(b, d, m) === 1) {
      cache.ord.set(key, d);
      return d;
    }
  }

  throw new Error('could not compute ord(b, m)');
}

export function primeFactors(n: number): number[] {
  if (cache.primeFactors.has(n)) {
    return cache.primeFactors.get(n)!;
  }

  const ds = divisors(n);
  const primes: number[] = [];

  for (const d of ds) {
    if (d > 1 && divisors(d).size === 2) {
      primes.push(d);
    }
  }

  cache.primeFactors.set(n, primes);
  return primes;
}

export function sigma(n: number): number {
  return Array.from(divisors(n)).reduce((acc, _) => acc + _, 0);
}

export function tau(n: number): number {
  return divisors(n).size;
}

export function totient(n: number): number {
  if (cache.totient.has(n)) {
    return cache.totient.get(n)!;
  }

  if (n === 1) {
    return 0;
  }

  let phi = n;
  const ps = primeFactors(n);
  for (const p of ps) {
    phi *= 1 - 1 / p;
  }

  phi = Math.floor(phi);

  cache.totient.set(n, phi);
  return phi;
}
