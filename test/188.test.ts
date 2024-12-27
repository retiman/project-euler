import compute from '../src/188';

describe('hyperexponentiation', () => {
  test('problem 188', async () => {
    expect(compute()).toBe(95962097);
  });
});
