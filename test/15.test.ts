import _ from 'lodash';
import compute from '../src/15';

describe('lattice paths', () => {
  test('problem 15', async () => {
    // Jest cannot compare bigints very well, so we have to convert them to strings.
    const value = _.toString(compute());
    expect(value).toBe('137846528820');
  });
});
