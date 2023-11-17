from py_testgen_app.src.ChatGPT.Kruskal.PromptOnly.T3.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):
    def setUp(self):
        # Initialize a Kruskal instance for testing
        self.kruskal = Kruskal(7)  # Assuming 7 vertices for the graphs

    def test_graph_1(self):
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

        expected_mst = [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 0, 7), (4, 1, 7), (4, 3, 15)]
        self.assertEqual(self.kruskal.run_kruskal_algorithm(), expected_mst)

    def test_graph_2(self):
        self.kruskal.add_edge(0, 1, -3)
        self.kruskal.add_edge(0, 4, 1)
        self.kruskal.add_edge(4, 1, 4)
        self.kruskal.add_edge(2, 1, 9)
        self.kruskal.add_edge(2, 4, 3)
        self.kruskal.add_edge(4, 3, 2)

        expected_mst = [(0, 1, -3), (0, 4, 1), (4, 3, 2), (4, 2, 3)]
        self.assertEqual(self.kruskal.run_kruskal_algorithm(), expected_mst)

    def test_empty_graph(self):
        empty_kruskal = Kruskal(0)
        self.assertEqual(empty_kruskal.run_kruskal_algorithm(), [])
