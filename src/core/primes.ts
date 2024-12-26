import * as fs from 'fs';
import * as path from 'path';
import { toNumber } from 'lodash';

export function primes(): number[] {
  return fs.readFileSync(path.join('data', 'primes.txt')).toString().split('\n').map(toNumber);
}
