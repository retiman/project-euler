import mexpt from '../../src/core/modular-exponentiation';

describe('modular exponentiation', () => {
  test('mexpt', async () => {
    expect(mexpt(3, 1, 2)).toBe(1);
    expect(mexpt(3, 0, 9)).toBe(1);
    expect(mexpt(5, 3, 13)).toBe(8);
    expect(mexpt(4, 13, 497)).toBe(445);
  });
});
