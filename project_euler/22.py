# Problem 22: Names Scores
#
# What is the total of all the name scores in the file?
#
# See https://projecteuler.net/problem=22
from pathlib import Path

def read_names():
    file = Path(__file__).parent / "data" / "22.txt"
    names = file.read_text().split(",")
    return [name[1:-1] for name in names]

def create_score_map():
    codes = [chr(c) for c in range(ord("A"), ord("Z") + 1)]
    values = range(1, len(codes) + 1)
    return dict(zip(codes, values))


def run():
    mapping = create_score_map()
    names = sorted(read_names())
    result = 0

    for i, name in enumerate(names):
        score = sum([mapping[c] for c in name])
        result += score * (i + 1)

    return result

def test_run():
    assert run() == 871198282