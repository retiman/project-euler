import numpy as np


memo: dict[int, np.ndarray] = {}


def divisors(n: int) -> np.ndarray:
    if n in memo:
        return memo[n]

    # Use trial division to find all divisors of n, up to sqrt(n).  Only check up to sqrt(n) because you can't have a
    # divisors greater than sqrt(n) that isn't paired with a divisor less than sqrt(n).
    divisors = np.array([i for i in range(1, int(np.sqrt(n)) + 1) if n % i == 0])

    # Find those other divisor in the pair for each divisor found above.
    paired = n // divisors

    # Remove duplicates and sort the list.
    all = np.concatenate((divisors, paired))
    return np.sort(np.unique(all))
