import primes from './core/primes';

// Computes the value of n for which φ((n) is a permutation of n and the ratio n/φ(n) produces a minimum.
//
// See {@link https://projecteuler.net/problem=70}
export default function compute(limit: number) {
  const pairs = getSemiPrimePairs(getLimit(limit))
    .map(pair => transformPair(pair))
    .filter(pair => isWithinLimit(pair, limit))
    .filter(pair => isPermutation(pair));

  let minRatio = limit;
  let result = 0;

  for (const [phi, n] of pairs) {
    const ratio = n / phi;
    if (ratio < minRatio) {
      minRatio = ratio;
      result = n;
    }
  }

  return result;
}

// This is a special totient function that optimizes the computation of totient for a semi-prime whose factors are p
// and q.
//
// For a prime number, the totient is simply (sub1 p).  Because the totient is a multiplicative function,
// totient(p * q) = totient(p) * totient(q).  Therefore, the totient of a semi-prime is simply (p - 1) * (q - 1).
function totient(p: number, q: number): number {
  return (p - 1) * (q - 1);
}

// Checks if two positive integers' digits are permutations of each other.
function isPermutation(pair: [number, number]): boolean {
  const [m, n] = pair;
  return m.toString().split('').sort().join('') === n.toString().split('').sort().join('');
}

function getLimit(limit: number): number {
  return 2 * (Math.floor(Math.sqrt(limit)) + 1);
}

function isWithinLimit(pair: [number, number], limit: number): boolean {
  return pair[1] < limit;
}

function getSemiPrimePairs(limit: number): [number, number][] {
  const ps = primes().filter(p => p < limit);
  const pairs: [number, number][] = [];

  for (let i = 0; i < ps.length; i++) {
    for (let j = i; j < ps.length; j++) {
      const p = ps[i];
      const q = ps[j];
      pairs.push([p, q]);
    }
  }

  return pairs;
}

// Creates totient to semi-prime pairs.
function transformPair(factors: [number, number]): [number, number] {
  const [p, q] = factors;
  const n = p * q;
  return [totient(p, q), n];
}
