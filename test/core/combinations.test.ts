import combinations from '../../src/core/combinations';

describe('combinations', () => {
  test('combinations', async () => {
    expect(combinations(0, 0)).toBe(1);
    expect(combinations(100, 0)).toBe(1);
    expect(combinations(100, 100)).toBe(1);
    expect(combinations(5, 2)).toBe(10);
    expect(combinations(10, 3)).toBe(120);
  });
});
