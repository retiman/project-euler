// [minhuang@mocha:javascript(master*)]$ time js -f problem-00004.js 
// 906609
//
// real 0m8.668s
// user 0m8.541s
// sys  0m0.092s
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
