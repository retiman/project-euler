import _ from 'lodash';

// Finds the largest palindrome made from the product of two 3-digit numbers.
//
// See {@link https://projecteuler.net/problem=4}.
export default function compute() {
  let max = 0;

  // To speed up the search, we can limit the search space and search backwards.  We want to find the largest
  // palindrome, so we start with the largest numbers first.
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
  const s = _.toString(n);
  return s === s.split('').reverse().join('');
}
