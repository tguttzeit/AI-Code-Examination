from py_testgen_app.src.ChatGPT.Kruskal.BookExampleCode.T1.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):

    def setUp(self):
        # Initialize Kruskal object and add edges for each test case
        self.kruskal = Kruskal(7)  # Assuming 7 vertices for Graph 1
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

        self.kruskal2 = Kruskal(5)  # Assuming 5 vertices for Graph 2
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_algorithm_graph1(self):
        mst = self.kruskal.run_kruskal_algorithm()
        expected_mst = [(0, 3, 5), (3, 5, 6), (1, 2, 8), (1, 4, 7), (4, 6, 9), (0, 1, 7)]
        self.assertEqual(sorted(mst), sorted(expected_mst))

    def test_kruskal_algorithm_graph2(self):
        mst = self.kruskal2.run_kruskal_algorithm()
        expected_mst = [(0, 1, -3), (0, 4, 1), (4, 3, 2), (2, 4, 3)]
        self.assertEqual(sorted(mst), sorted(expected_mst))

    def test_kruskal_algorithm_empty_graph(self):
        kruskal_empty = Kruskal(0)
        mst = kruskal_empty.run_kruskal_algorithm()
        self.assertEqual(len(mst), 0)
