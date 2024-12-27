import totient from '../../src/core/totient';

describe('totient', () => {
  test('totient', async () => {
    expect(totient(1)).toBe(0);
    expect(totient(7)).toBe(6);
    expect(totient(15)).toBe(8);
    expect(totient(2015)).toBe(1440);
  });
});
