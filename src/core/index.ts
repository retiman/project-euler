import * as fs from 'fs';
import * as path from 'path';

export function read(file: string): string[] {
  return fs.readFileSync(path.join('data', file)).toString().trim().split('\n');
}
