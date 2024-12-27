import _ from 'lodash';
import compute from '../src/48';

describe('self powers', () => {
  test('problem 48', async () => {
    const value = compute();
    expect(_.toString(value)).toBe('9110846700');
  });
});
