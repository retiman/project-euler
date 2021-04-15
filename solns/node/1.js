const result = [...Array(1000).keys()]
  .filter(x => x % 3 === 0 || x % 5 === 0)
  .reduce((x, y) => x + y)

console.log(result)
console.assert(result === 233168)
