import lcm from '../../src/core/lcm';

describe('least common multiple', () => {
  test('lcm', async () => {
    expect(lcm(12, 18)).toBe(36);
  });
});
