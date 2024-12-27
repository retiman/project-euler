import mtetn from '../../src/core/modular-tetration';

describe('modular tetration', () => {
  test('mtetn', async () => {
    expect(mtetn(3, 1, 2)).toBe(3 ** 1 % 2);
    expect(mtetn(3, 2, 20)).toBe(3 ** 3 % 20);
    expect(mtetn(3, 3, 345)).toBe(312);
    expect(mtetn(5, 2, 7)).toBe(5 ** 5 % 7);
    expect(mtetn(7, 4, 13)).toBe(6);
    expect(mtetn(10, 2, 6)).toBe(10 ** 10 % 6);
  });
});
