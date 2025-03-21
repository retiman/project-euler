import math


memo: dict[int, list[int]] = {}


def divisors(n: int) -> list[int]:
    if n in memo:
        return memo[n]

    ds: set[int] = set()

    # Use trial division to find all divisors of n, up to sqrt(n).  Only check up to sqrt(n) because you can't have a
    # divisors greater than sqrt(n) that isn't paired with a divisor less than sqrt(n).
    #
    # Also, try to reuse the known results of smaller divisors if we can.
    limit = int(math.sqrt(n)) + 1
    for i in range(1, limit):
        if n % i == 0:
            ds.add(i)
            ds.add(n // i)

            # If we have a known set of divisors for i, we can use that to find the divisors of n.  Only do this if the
            # divisors are non-trivial (i.e. not just 1 and i).
            if i > 1 and i in memo and len(memo[i]) > 2:
                known = memo[i]
                candidates = {j for j in known if n % j == 0}
                complement = {n // j for j in candidates}
                memo[n] = sorted(candidates.union(complement))
                return memo[n]

    memo[n] = sorted(ds)
    return memo[n]
