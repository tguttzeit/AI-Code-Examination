from py_app.src.ChatGPT.Kruskal.T48.kruskal import Kruskal

import unittest


class KruskalTest(unittest.TestCase):

    def test_1(self):
        self.kruskal = Kruskal(7)
        self.kruskal.add_edge(0, 1, 7)
        self.kruskal.add_edge(1, 2, 8)
        self.kruskal.add_edge(0, 3, 5)
        self.kruskal.add_edge(1, 3, 9)
        self.kruskal.add_edge(1, 4, 7)
        self.kruskal.add_edge(2, 4, 5)
        self.kruskal.add_edge(3, 4, 15)
        self.kruskal.add_edge(3, 5, 6)
        self.kruskal.add_edge(4, 5, 8)
        self.kruskal.add_edge(4, 6, 9)
        self.kruskal.add_edge(5, 6, 11)
        expected_nodes = [0, 1, 2, 3, 4, 5, 6]
        expected_costs = 39
        results_dict = evaluate_results(self.kruskal.run_kruskal_algorithm())
        self.assertEqual(expected_nodes, list(results_dict["set"]))
        self.assertEqual(expected_costs, results_dict["sum"])

    def test_2(self):
        self.kruskal = Kruskal(5)
        self.kruskal.add_edge(0, 1, -3)
        self.kruskal.add_edge(0, 4, 1)
        self.kruskal.add_edge(4, 1, 4)
        self.kruskal.add_edge(2, 1, 9)
        self.kruskal.add_edge(2, 4, 3)
        self.kruskal.add_edge(4, 3, 2)
        expected_nodes = [0, 1, 2, 3, 4]
        expected_costs = 3
        results_dict = evaluate_results(self.kruskal.run_kruskal_algorithm())
        self.assertEqual(expected_nodes, list(results_dict["set"]))
        self.assertEqual(expected_costs, results_dict["sum"])

    # TODO: Test with empty graph


def evaluate_results(edges) -> dict[str, any]:
    """
    This method is used to evaluate the results of the Kruskal algorithm.
    :param edges: The edges of the graph, represented as a list of tuples.
    :return: A dict containing the sum of the weights and the set of nodes.
    """
    results = {"sum": 0}
    nodes = list()
    for (src, dest, weight) in edges:
        results["sum"] += weight
        nodes.append(src)
        nodes.append(dest)
    results["set"] = set(nodes)
    return results
