export function compute() {
  const map = new Map<number, string>(
    [
      [1, "one"], [2, "two"], [3, "three"], [4, "four"], [5, "five"], [6, "six"], [7, "seven"], [8, "eight"], [9, "nine"],
      [10, "ten"], [11, "eleven"], [12, "twelve"], [13, "thirteen"], [14, "fourteen"], [15, "fifteen"], [16, "sixteen"],
      [17, "seventeen"], [18, "eighteen"], [19, "nineteen"], [20, "twenty"], [30, "thirty"], [40, "forty"], [50, "fifty"],
      [60, "sixty"], [70, "seventy"], [80, "eighty"], [90, "ninety"]
    ]
  );

  function say(n: number): string {
      if (n === 1000) {
          return "one thousand";
      } else if (n >= 100 && n % 100 !== 0) {
        const key = Math.floor(n / 100);
          return `${map.get(key)} hundred and ${say(n % 100)}`;
      } else if (n >= 100) {
        const key =Math.floor(n / 100);
          return `${map.get(key)} hundred`;
      } else if (n >= 20 && n % 10 !== 0) {
        const key =n - (n % 10);
          return `${map.get(key)} ${say(n % 10)}`;
      } else if (n >= 20) {
          return map.get(n)!;
      } else {
          return map.get(n)!;
      }
  }

    let sum = 0;
    for (let i = 1; i <= 1000; i++) {
        sum += say(i).replace(/\s+/g, "").length;
    }
    return sum;
}
