import { toString } from 'lodash';

export function compute() {
  let max = 0;

  // Search backwards from 1000 because we want to find the max palindrome.
  for (let i = 999; i > 99; i--) {
    for (let j = 999; j > 99; j--) {
      const n = i * j;
      if (isPalindrome(n) && n > max) {
        max = n;
      }
    }
  }

  return max;
}

function isPalindrome(n: number) {
  const s = toString(n);
  return s === s.split('').reverse().join('');
}
