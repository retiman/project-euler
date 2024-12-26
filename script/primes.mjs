import fs from 'fs';
import path from 'path';
import process from 'process';

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
