from py_testgen_app.src.ChatGPT.Kruskal.AIGenerated.T10.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):
    def setUp(self):
        self.kruskal = Kruskal(7)  # For Graph 1

    def test_kruskal_algorithm_graph1(self):
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

        expected_result = [[0, 3, 5], [1, 0, 7], [2, 4, 5], [3, 5, 6], [4, 1, 7], [5, 6, 11]]
        self.assertEqual(self.kruskal.run_kruskal_algorithm(), expected_result)

    def test_kruskal_algorithm_graph2(self):
        self.kruskal = Kruskal(5)  # For Graph 2
        self.kruskal.add_edge(0, 1, -3)
        self.kruskal.add_edge(0, 4, 1)
        self.kruskal.add_edge(4, 1, 4)
        self.kruskal.add_edge(2, 1, 9)
        self.kruskal.add_edge(2, 4, 3)
        self.kruskal.add_edge(4, 3, 2)

        expected_result = [[0, 1, -3], [0, 4, 1], [4, 3, 2], [2, 4, 3]]
        self.assertEqual(self.kruskal.run_kruskal_algorithm(), expected_result)

    def test_empty_graph(self):
        self.kruskal = Kruskal(0)
        self.assertEqual(self.kruskal.run_kruskal_algorithm(), [])
