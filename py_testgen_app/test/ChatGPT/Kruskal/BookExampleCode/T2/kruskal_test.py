from py_testgen_app.src.ChatGPT.Kruskal.BookExampleCode.T2.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):
    def setUp(self):
        self.kruskal = Kruskal(7)  # Initialize with 7 vertices

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
        self.kruskal2 = Kruskal(5)  # Initialize with 5 vertices
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_graph1(self):
        mst = self.kruskal.run_kruskal_algorithm()
        self.assertEqual(len(mst), 6)  # MST should have 6 edges

        # Check that all edges in the MST exist in the original graph
        for edge in mst:
            self.assertIn(edge, self.kruskal.edges)

    def test_kruskal_graph2(self):
        mst = self.kruskal2.run_kruskal_algorithm()
        self.assertEqual(len(mst), 4)  # MST should have 4 edges

        # Check that all edges in the MST exist in the original graph
        for edge in mst:
            self.assertIn(edge, self.kruskal2.edges)

    def test_empty_graph(self):
        empty_graph = Kruskal(0)  # Test with an empty graph
        mst = empty_graph.run_kruskal_algorithm()
        self.assertEqual(len(mst), 0)  # MST of an empty graph should also be empty
