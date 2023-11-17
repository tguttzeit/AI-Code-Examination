from py_testgen_app.src.ChatGPT.Kruskal.AIGenerated.T5.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):
    def setUp(self):
        # Initialize Kruskal instance and add edges for each test case
        self.kruskal = Kruskal(7)  # For Graph 1
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

        self.kruskal2 = Kruskal(5)  # For Graph 2
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_algorithm_graph1(self):
        result = self.kruskal.run_kruskal_algorithm()
        # Verify the minimum spanning tree has the expected edges and weight
        self.assertEqual(result, [[0, 3, 5], [2, 4, 5], [3, 5, 6], [1, 0, 7], [4, 1, 7], [4, 6, 9], [5, 6, 11]])

    def test_kruskal_algorithm_graph2(self):
        result = self.kruskal2.run_kruskal_algorithm()
        # Verify the minimum spanning tree has the expected edges and weight
        self.assertEqual(result, [[0, 1, -3], [4, 3, 2], [0, 4, 1], [2, 4, 3]])

    def test_empty_graph(self):
        empty_kruskal = Kruskal(0)
        result = empty_kruskal.run_kruskal_algorithm()
        # An empty graph should result in an empty minimum spanning tree
        self.assertEqual(result, [])
