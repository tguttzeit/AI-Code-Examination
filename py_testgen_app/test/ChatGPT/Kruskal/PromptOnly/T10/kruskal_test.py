from py_testgen_app.src.ChatGPT.Kruskal.PromptOnly.T10.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):

    def setUp(self):
        self.graph1 = Kruskal(7)
        self.graph2 = Kruskal(5)

        # Add edges for Graph 1
        self.graph1.add_edge(5, 6, 11)
        self.graph1.add_edge(0, 1, 7)
        self.graph1.add_edge(1, 2, 8)
        self.graph1.add_edge(0, 3, 5)
        self.graph1.add_edge(1, 3, 9)
        self.graph1.add_edge(1, 4, 7)
        self.graph1.add_edge(2, 4, 5)
        self.graph1.add_edge(3, 4, 15)
        self.graph1.add_edge(3, 5, 6)
        self.graph1.add_edge(4, 5, 8)
        self.graph1.add_edge(4, 6, 9)

        # Add edges for Graph 2
        self.graph2.add_edge(0, 1, -3)
        self.graph2.add_edge(0, 4, 1)
        self.graph2.add_edge(4, 1, 4)
        self.graph2.add_edge(2, 1, 9)
        self.graph2.add_edge(2, 4, 3)
        self.graph2.add_edge(4, 3, 2)

    def test_graph1_kruskal(self):
        mst_edges = self.graph1.run_kruskal_algorithm()
        # Expected minimum spanning tree edges for Graph 1
        expected_mst_edges = [(0, 3, 5), (2, 4, 5), (1, 4, 7), (3, 5, 6), (4, 6, 9), (0, 1, 7)]
        self.assertEqual(sorted(mst_edges), sorted(expected_mst_edges))

    def test_graph2_kruskal(self):
        mst_edges = self.graph2.run_kruskal_algorithm()
        # Expected minimum spanning tree edges for Graph 2
        expected_mst_edges = [(0, 1, -3), (0, 4, 1), (4, 3, 2), (2, 4, 3)]
        self.assertEqual(sorted(mst_edges), sorted(expected_mst_edges))

    def test_invalid_edge(self):
        # Test adding an invalid edge to Graph 1
        with self.assertRaises(ValueError):
            self.graph1.add_edge(0, 8, 10)
