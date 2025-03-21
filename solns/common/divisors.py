import numpy as np

def divisors(n: int) -> np.ndarray:
    """Returns a sorted list of all divisors of n."""
    # Use trial division to find all divisors of n.
    divisors = np.array([i for i in range(1, int(np.sqrt(n)) + 1) if n % i == 0])
    paired_divisors = n // divisors
    all_divisors = np.unique(np.concatenate((divisors, paired_divisors)))
    return np.sort(all_divisors)

# Example usage:
num = 36
print(get_divisors(num))  # Output: [ 1  2  3  4  6  9 12 18 36]