import _ from 'lodash';
import mexpt from '../../src/core/modular-exponentiation-bigint';

describe('modular exponentiation with bigint', () => {
  test('mexpt', async () => {
    expect(_.toString(mexpt(3n, 1n, 2n))).toBe('1');
    expect(_.toString(mexpt(3n, 0n, 9n))).toBe('1');
    expect(_.toString(mexpt(5n, 3n, 13n))).toBe('8');
    expect(_.toString(mexpt(4n, 13n, 497n))).toBe('445');
  });
});
