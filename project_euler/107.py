# Problem 107: Minimal Network
#
# Find the maximum saving which can be achieved by removing redundant edges whilst ensuring that the network remains
# connected.
#
# See https://projecteuler.net/problem=107
from heapq import heappop, heappush
import math
from pathlib import Path


Graph = list[list[float]]
Edge = tuple[int, int]


def create_graph() -> Graph:
    file = Path(__file__).parent / "data" / "107.txt"
    data = file.read_text().strip().splitlines()
    graph: Graph = []

    for line in data:
        # fmt: off
        row = [
            math.inf
            if x == "-" else int(x)
            for x in line.strip().split(",")
        ]
        # fmt: on
        graph.append(row)

    return graph


def weight_of_network(graph: Graph) -> float:
    total = 0

    for i, row in enumerate(graph):
        for j, x in enumerate(row):
            if x != math.inf:
                total += x

    # Divide by 2 to avoid double counting in undirected graph.
    return total / 2


def weight_of_mst(graph: Graph, edges: list[Edge]) -> float:
    return sum(graph[u][v] for u, v in edges)


def neighbors(graph: Graph, u: int) -> list[tuple[int, float]]:
    # fmt: off
    return [
        (v, graph[u][v])
        for v in range(len(graph))
        if graph[u][v] != math.inf
    ]
    # fmt: on


def mst(graph: Graph) -> list[Edge]:
    n = len(graph)
    visited: set[int] = set()
    edges: list[Edge] = []
    min_heap: list[tuple[float, int, int]] = []

    visited.add(0)

    for v, weight in neighbors(graph, 0):
        heappush(min_heap, (weight, 0, v))

    while len(visited) < n and min_heap:
        _, u, v = heappop(min_heap)
        if v in visited:
            continue

        visited.add(v)
        edges.append((u, v))
        for w, weight in neighbors(graph, v):
            if w not in visited:
                heappush(min_heap, (weight, v, w))

    return edges


def run() -> int:
    graph = create_graph()
    edges = mst(graph)

    network_weight = weight_of_network(graph)
    mst_weight = weight_of_mst(graph, edges)

    return int(network_weight - mst_weight)


def test_run():
    assert run() == 259679
