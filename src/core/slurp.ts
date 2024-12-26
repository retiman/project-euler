import fs from 'fs';
import path from 'path';

export default function slurp(name: string): string {
  return fs.readFileSync(path.join('data', name), 'utf8').toString();
}
