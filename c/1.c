// 233168
//
// real	0m0.001s
// user	0m0.003s
// sys	0m0.000s

#include <stdio.h>

int main()
{
  int sum = 0;
  int i = 0;
  for (i = 0; i < 1000; i++) {
    if (i % 3 == 0) {
      sum += i;
    } else if (i % 5 == 0) {
      sum += i;
    }
  }
  printf("%d\n", sum);
  return 0;
}
