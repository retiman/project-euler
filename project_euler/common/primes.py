from pathlib import Path
import numpy as np


primes: set[int] = set()


def primes_under(n: int) -> np.ndarray:
    """Returns all prime numbers less than n."""
    if n < 2:
        return np.array([], dtype=int)

    # Create a boolean array of n elements, all defaulting to True.  This is less efficient than running a sieve on only
    # odd numbers, but it's sufficient for the problems we are working with.
    sieve = np.ones(n, dtype=bool)

    # Mark 0 and 1 as non-prime.
    sieve[0:2] = False

    # Only consider up to (and including) the sqrt(n); any number greater than sqrt(n) that is a multiple of a number
    # less than sqrt(n) would have already been marked as non-prime.
    limit = int(np.sqrt(n)) + 1
    for i in range(2, limit):
        # Mark all multiples of i as non-prime.
        if sieve[i]:
            sieve[i * i : n : i] = False

    # Extract indices where the sieve is True (primes).
    return np.flatnonzero(sieve).astype(int)


def write_primes(limit: int) -> None:
    primes = primes_under(limit)
    path = Path(__file__).parent / ".." / "data" / "primes.txt"
    with path.open("w", encoding="utf-8") as file:
        for prime in primes:
            file.write(f"{prime}\n")


def read_primes() -> list[int]:
    path = Path(__file__).parent / ".." / "data" / "primes.txt"
    with path.open("r", encoding="utf-8") as file:
        return [int(line.strip()) for line in file]


def is_prime(n: int) -> bool:
    if not primes:
        primes.update(read_primes())

    return n in primes


if __name__ == "__main__":
    write_primes(5_000_000)
