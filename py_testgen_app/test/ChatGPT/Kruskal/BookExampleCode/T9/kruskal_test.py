from py_testgen_app.src.ChatGPT.Kruskal.BookExampleCode.T9.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):

    def setUp(self):
        self.kruskal = Kruskal(7)  # Initialize Kruskal with 7 vertices for Graph 1
        self.kruskal2 = Kruskal(5)  # Initialize Kruskal with 5 vertices for Graph 2

        # Graph 1 edges and weights
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

        # Graph 2 edges and weights
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_graph1(self):
        # Expected MST for Graph 1
        expected_mst = [(0, 3, 5), (1, 0, 7), (3, 5, 6), (4, 2, 5), (4, 1, 7), (2, 4, 5)]

        mst = self.kruskal.run_kruskal_algorithm()
        self.assertEqual(mst, expected_mst)

    def test_kruskal_graph2(self):
        # Expected MST for Graph 2
        expected_mst = [(0, 1, -3), (4, 3, 2), (0, 4, 1), (2, 4, 3)]

        mst = self.kruskal2.run_kruskal_algorithm()
        self.assertEqual(mst, expected_mst)

    def test_kruskal_empty_graph(self):
        # Test an empty graph
        empty_kruskal = Kruskal(0)
        mst = empty_kruskal.run_kruskal_algorithm()
        self.assertEqual(mst, [])
