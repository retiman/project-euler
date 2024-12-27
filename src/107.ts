import _ from 'lodash';
import slurp from './core/slurp';

type Graph = number[][];
type Edge = [number, number];

// Computes the maximum savings that can be achieved by removing redundant edges from a network graph.
//
// @remarks
// Uses Prim's algorithm to construct a minimum spanning tree.
//
// See {@link https://en.wikipedia.org/wiki/Prim%27s_algorithm}.
// See {@link https://projecteuler.net/problem=107}.
export default function compute() {
  const graph = parse();

  // This is the total cost of the network, computed by summing all edge weights.
  const weight1 = getWeightOfAllEdges(graph);

  // This is a set of edges that form a minimum spanning tree of the network.
  const edges = getMinimumSpanningTree(graph);

  // This is the total cost of the minimum spanning tree.
  const weight2 = getWeightOfEdges(graph, edges); // Calculate MST cost

  // The delta between the total weight and the MST weight is our savings.
  return Math.floor(weight1 - weight2);
}

function parse(): Graph {
  return slurp('107.txt')
    .trim()
    .split('\n')
    .map(line => {
      return line.split(',').map(value => (value === '-' ? Infinity : _.toNumber(value)));
    });
}

function getWeightOfAllEdges(graph: Graph) {
  let total = 0;

  for (const row of graph) {
    total += row.reduce((sum, value) => {
      if (value === Infinity) {
        return sum;
      }

      return sum + value;
    }, 0);
  }

  return total / 2;
}

function getWeightOfEdges(graph: Graph, edges: Set<Edge>): number {
  let total = 0;

  for (const edge of edges) {
    total += getWeight(graph, edge);
  }

  return total;
}

function getWeight(graph: Graph, edge: Edge) {
  const [u, v] = edge;
  return graph[u][v];
}

function getNeighbors(graph: Graph, u: number) {
  const n = graph.length;
  const result = new Set<number>();

  for (let v = 0; v < n; v++) {
    if (graph[u][v] !== Infinity) {
      result.add(v);
    }
  }

  return result;
}

function getFrontierNodes(graph: Graph, nodes: Set<number>): Set<Edge> {
  const edges = new Set<Edge>();

  for (const u of nodes) {
    for (const v of getNeighbors(graph, u)) {
      if (!nodes.has(v)) {
        edges.add([u, v]);
      }
    }
  }

  return edges;
}

function getCheapestEdge(graph: Graph, vertices: Set<number>, excluded: Set<string>): Edge {
  let minEdge: Edge = [-1, -1];
  let minCost = Infinity;

  for (const edge of getFrontierNodes(graph, vertices)) {
    const [u, v] = edge;
    const key = `${u}-${v}`;

    if (!excluded.has(key)) {
      const edgeCost = getWeight(graph, edge);
      if (edgeCost < minCost) {
        minCost = edgeCost;
        minEdge = edge;
      }
    }
  }

  return minEdge;
}

function getMinimumSpanningTree(graph: Graph): Set<Edge> {
  const nodes = new Set<number>([0]);
  const mst = new Set<Edge>();
  const excluded = new Set<string>();

  while (nodes.size < graph.length) {
    const edge = getCheapestEdge(graph, nodes, excluded);
    if (edge[0] === -1) {
      break;
    }

    nodes.add(edge[0]);
    nodes.add(edge[1]);
    mst.add(edge);

    excluded.add(`${edge[0]}-${edge[1]}`);
    excluded.add(`${edge[1]}-${edge[0]}`);
  }

  return mst;
}
