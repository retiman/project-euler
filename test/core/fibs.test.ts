import fibs from '../../src/core/fibs';

describe('fibs', () => {
  test('fibs', async () => {
    expect(fibs(0)).toStrictEqual([]);
    expect(fibs(1)).toStrictEqual([0]);
    expect(fibs(10)).toStrictEqual([0, 1, 1, 2, 3, 5, 8]);
  });
});
