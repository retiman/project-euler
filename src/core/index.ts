import fs from 'fs';
import path from 'path';

export function read(file: string): string[] {
  return fs.readFileSync(path.join('data', file), 'utf8').toString().trim().split('\n');
}
