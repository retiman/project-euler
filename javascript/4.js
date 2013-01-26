String.prototype.reverse = function () {
  return Array.prototype.slice.apply(this).reverse().join('');
};

String.prototype.isPalindrome = function () {
  // Note that a primitive JavaScript string is not === to a String object.
  // The valueOf function returns the underlying primitive.
  return this.valueOf() === this.reverse().valueOf();
};

let result = 0;
for (let i = 999; i > 0; i--) {
  for (let j = i; j > 0; j--) {
    let x = i * j;
    if (x.toString().isPalindrome() && x > result)
      result = x;
  }
}
print(result);
