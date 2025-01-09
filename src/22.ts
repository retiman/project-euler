// Computes name scores based on the names in the text file.
//
// See {@link https://projecteuler.net/problem=22}
import _ from 'lodash';
import slurp from './core/slurp';

function getNames() {
  return slurp('22.txt')
    .split(',')
    .map(line => line.slice(1, -1))
    .sort((a, b) => a.localeCompare(b));
}

function getScores() {
  const codes = _.range('A'.charCodeAt(0), 'Z'.charCodeAt(0) + 1).map(c => String.fromCharCode(c))
  const values = _.range(1, 27);
  return new Map(_.zip(codes, values) as [[string, number]]);
}

function getScore(name: string, scores: Map<string, number>) {
  return name.split('').reduce((a, b) => a + scores.get(b)!, 0);
}

export default function compute() {
  const scores = getScores();
  const names = getNames();

  let result = 0;
  for (let i = 0; i < names.length; i++) {
    const name = names[i];
    const score = getScore(name, scores);
    result += (i + 1) * score;
  }

  return result;
}