import _ from 'lodash';
import factorial from '../../src/core/factorial';

describe('factorial', () => {
  // Jest can't compare bigints very well, so we have to convert them to strings.
  test('factorial', async () => {
    expect(_factorial(0)).toBe('1');
    expect(_factorial(1)).toBe('1');
    expect(_factorial(5)).toBe('120');
    expect(_factorial(10)).toBe('3628800');
  });

  function _factorial(n: number): string {
    return _.toString(factorial(n));
  }
});
