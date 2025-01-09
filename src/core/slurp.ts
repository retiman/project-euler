import fs from 'fs';
import path from 'path';

export default function slurp(name: string): string {
  const file = path.join('data',  name);
  return fs.readFileSync(file, 'utf8').toString();
}
