import * as fs from 'fs';
import * as path from 'path';
import * as process from 'process';
import { generatePrimes } from 'prime-lib';

const limit = Number.parseInt(process.argv[2], 10 /* radix */);
const primes = [...generatePrimes({ end: limit })].join('\n');
const output = path.join('data', 'primes.txt');

fs.writeFileSync(output, primes);
