# Problem 8: Largest Product in a Series
#
# Find the thirteen adjacent digits in the  1000 digit number that have the greatest product. What is the value of this
# product?
#
# See https://projecteuler.net/problem=8
from pathlib import Path


def run(window: int) -> int:
    file = Path(__file__).parent / "data" / "8.txt"
    data = "".join(file.read_text().splitlines())

    # Can be solved with a sliding window algorithm.  We just have to take care to note the number of zeroes in the
    # window; if a window has any zeroes in it, thet product of that window will be zero.  At each step, we only compute
    # the product if we have no zeroes in the window.
    zeroes = 0
    max_product = 0
    product = 1

    for i in range(len(data) - window):
        # Create our window if we haven't seen enough elements.
        if i < window:
            digit = int(data[i])
            if digit == 0:
                zeroes += 1
                continue

            product *= digit
            if zeroes == 0:
                max_product = max(max_product, product)

            continue

        # Otherwise, slide the window through the rest of the data.
        incoming = data[i]
        outgoing = data[i - window]

        # Multiply the product by the incoming digit if it's non-zero.
        if incoming != "0":
            product *= int(incoming)
        else:
            zeroes += 1

        # Divide the product by the outgoing digit if it's non-zero.
        if outgoing != "0":
            product /= int(outgoing)
        else:
            zeroes -= 1

        # Update max product only if there are no zeros in the current window.
        if zeroes == 0:
            max_product = max(max_product, product)

    return int(max_product)


def test_run():
    assert run(13) == 23514624000
