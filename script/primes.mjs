import fs from 'fs';
import path from 'path';
import process from 'process';

// Implements of the Sieve of Eratosthenes algorithm up to a given limit.
//
// @remarks
// Writes the primes to a file for use in other problems.
//
// See {@link https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes}.
function sieve(n) {
  const primes = new Array(n + 1).fill(true);
  primes[0] = primes[1] = false;

  for (let i = 2; i * i <= n; i++) {
    if (primes[i]) {
      for (let j = i * i; j <= n; j += i) {
        primes[j] = false;
      }
    }
  }

  return primes.map((isPrime, i) => (isPrime ? i : -1)).filter(i => i !== -1);
}

const limit = Number.parseInt(process.argv[2], 10 /* radix */);
const output = path.join('data', 'primes.txt');
const primes = sieve(limit);

fs.writeFileSync(output, primes.join('\n'));
