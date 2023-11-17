from py_testgen_app.src.ChatGPT.Kruskal.PromptOnly.T1.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):

    def setUp(self):
        self.graph1 = Kruskal(7)
        self.graph2 = Kruskal(5)

    def test_graph1(self):
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

        mst_edges = self.graph1.run_kruskal_algorithm()
        expected_mst_edges = [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 0, 7), (4, 1, 7), (4, 3, 15)]
        self.assertEqual(sorted(mst_edges), sorted(expected_mst_edges))

    def test_graph2(self):
        self.graph2.add_edge(0, 1, -3)
        self.graph2.add_edge(0, 4, 1)
        self.graph2.add_edge(4, 1, 4)
        self.graph2.add_edge(2, 1, 9)
        self.graph2.add_edge(2, 4, 3)
        self.graph2.add_edge(4, 3, 2)

        mst_edges = self.graph2.run_kruskal_algorithm()
        expected_mst_edges = [(0, 1, -3), (0, 4, 1), (4, 3, 2), (2, 4, 3)]
        self.assertEqual(sorted(mst_edges), sorted(expected_mst_edges))

    def test_empty_graph(self):
        empty_graph = Kruskal(0)
        mst_edges = empty_graph.run_kruskal_algorithm()
        self.assertEqual(mst_edges, [])
