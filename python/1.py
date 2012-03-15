# 233168
# 0.04user 0.00system 0:00.05elapsed 94%CPU (0avgtext+0avgdata 7192maxresident)k
# 0inputs+0outputs (0major+1902minor)pagefaults 0swaps

from functools import reduce
print(sum([n for n in range(1, 1000) if n % 3 == 0 or n % 5 == 0]))
