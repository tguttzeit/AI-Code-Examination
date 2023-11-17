from py_testgen_app.src.ChatGPT.Kruskal.AIGenerated.T7.kruskal import Kruskal

import unittest

class TestKruskalAlgorithm(unittest.TestCase):
    def setUp(self):
        self.kruskal = Kruskal(7)  # Create a Kruskal instance with 7 vertices for testing

    def test_graph1(self):
        # Build Graph 1
        self.kruskal.add_edge(5, 6, 11)
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

        # Run Kruskal's algorithm
        result = self.kruskal.run_kruskal_algorithm()

        # Assert that the minimum spanning tree has the expected edges and total weight
        expected_result = [[0, 3, 5], [3, 5, 6], [1, 0, 7], [2, 4, 5], [1, 4, 7], [4, 6, 9], [4, 5, 8]]
        self.assertEqual(sorted(result), sorted(expected_result))

    def test_graph2(self):
        # Build Graph 2
        self.kruskal.add_edge(0, 1, -3)
        self.kruskal.add_edge(0, 4, 1)
        self.kruskal.add_edge(4, 1, 4)
        self.kruskal.add_edge(2, 1, 9)
        self.kruskal.add_edge(2, 4, 3)
        self.kruskal.add_edge(4, 3, 2)

        # Run Kruskal's algorithm
        result = self.kruskal.run_kruskal_algorithm()

        # Assert that the minimum spanning tree has the expected edges and total weight
        expected_result = [[0, 1, -3], [4, 3, 2], [0, 4, 1], [4, 1, 4], [2, 4, 3]]
        self.assertEqual(sorted(result), sorted(expected_result))

    def test_empty_graph(self):
        # Test an empty graph
        result = self.kruskal.run_kruskal_algorithm()

        # Assert that the result is an empty list since there are no edges
        self.assertEqual(result, [])
