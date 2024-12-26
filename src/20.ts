import _ from 'lodash';

export function compute(limit: number) {
  let product = 2n;
  for (let i = 3n; i <= limit; i++) {
    product *= i;
  }

  const text = _.toString(product);
  console.log(text);

  let sum = 0;
  for (let i = 0; i < text.length; i++) {
    sum += _.toNumber(text[i]);
  }

  return sum;
}
