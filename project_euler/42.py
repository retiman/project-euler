# Problem 42: Coded Triangle Numbers
#
# How many are triangle words?
#
# See https://projecteuler.net/problem=42
from pathlib import Path


def read_words() -> list[str]:
    file = Path(__file__).parent / "data" / "42.txt"
    return file.read_text().replace('"', "").strip().split(",")


def word_score(word: str) -> int:
    return sum(ord(c) - ord("A") + 1 for c in word)


def triangle_numbers_up_to(limit: int) -> set[int]:
    n = 1
    triangles: set[int] = set()

    while (t := n * (n + 1) // 2) <= limit:
        triangles.add(t)
        n += 1

    return triangles


def run() -> int:
    words = read_words()
    scores = list(map(word_score, words))
    max_score = max(scores)
    triangle_numbers = triangle_numbers_up_to(max_score)
    return sum(1 for score in scores if score in triangle_numbers)


def test_run():
    assert run() == 162
