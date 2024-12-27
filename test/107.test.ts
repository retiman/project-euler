import compute from '../src/107';

describe('minimal network', () => {
  test('problem 107', async () => {
    expect(compute()).toBe(259679);
  });
});
