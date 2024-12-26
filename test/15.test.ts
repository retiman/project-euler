import _ from 'lodash';
import { compute } from '../src/15';

describe('lattice paths', () => {
  test('problem 15', async () => {
    expect(_.toString(compute(20, 20))).toBe('137846528820');
  });
});
