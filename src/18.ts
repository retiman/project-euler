export function compute() {
const input = `
  75
  95 64
  17 47 82
  18 35 87 10
  20 04 82 47 65
  19 01 23 75 03 34
  88 02 77 73 07 63 67
  99 65 04 28 06 16 70 92
  41 41 26 56 83 40 80 70 33
  41 48 72 33 47 32 37 16 94 29
  53 71 44 65 25 43 91 52 97 51 14
  70 11 33 28 77 73 17 78 39 68 17 57
  91 71 52 38 17 14 91 43 58 50 27 29 48
  63 66 04 68 89 53 67 30 73 16 69 87 40 31
  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23`;
const triangle = input.trim().split('\n').map(row => row.trim().split(' ').map(Number));


// Rather than calculating the path sums going down, look at the bottom row and
// the row above it.
//
// For example, assume that the tree has height 4 and that these are the last 2
// rows:
//
//  17 47 82
// 18 35 87 10
//
// At 17, you will never take the left path containing 18, because 35 + 17 is
// greater. At 47, you will never take the left path for 35, because 47 + 87 is
// greater, and so on.
//
// Therefore, these last 2 rows can be reduced to a single row once the optimal
// path is taken:
//
// 52 134 169
//
// Once this reduction is done, compare this newly constructed row to the one
// above it and perform the same reduction until only one row remains with one
// value.
    for (let i = triangle.length - 2; i >= 0; i--) {
        for (let j = 0; j < triangle[i].length; j++) {
            triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
        }
    }
    return triangle[0][0];
}
