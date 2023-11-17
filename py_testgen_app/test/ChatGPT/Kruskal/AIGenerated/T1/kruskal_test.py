from py_testgen_app.src.ChatGPT.Kruskal.AIGenerated.T1.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):

    def setUp(self):
        self.kruskal_graph1 = Kruskal(7)
        self.kruskal_graph2 = Kruskal(5)

        # Graph 1
        self.kruskal_graph1.add_edge(5, 6, 11)
        self.kruskal_graph1.add_edge(0, 1, 7)
        self.kruskal_graph1.add_edge(1, 2, 8)
        self.kruskal_graph1.add_edge(0, 3, 5)
        self.kruskal_graph1.add_edge(1, 3, 9)
        self.kruskal_graph1.add_edge(1, 4, 7)
        self.kruskal_graph1.add_edge(2, 4, 5)
        self.kruskal_graph1.add_edge(3, 4, 15)
        self.kruskal_graph1.add_edge(3, 5, 6)
        self.kruskal_graph1.add_edge(4, 5, 8)
        self.kruskal_graph1.add_edge(4, 6, 9)

        # Graph 2
        self.kruskal_graph2.add_edge(0, 1, -3)
        self.kruskal_graph2.add_edge(0, 4, 1)
        self.kruskal_graph2.add_edge(4, 1, 4)
        self.kruskal_graph2.add_edge(2, 1, 9)
        self.kruskal_graph2.add_edge(2, 4, 3)
        self.kruskal_graph2.add_edge(4, 3, 2)

    def test_kruskal_graph1(self):
        result = self.kruskal_graph1.run_kruskal_algorithm()
        # The MST should have 6 edges with a total weight of 39.
        self.assertEqual(len(result), 6)
        self.assertEqual(sum(edge[2] for edge in result), 39)

    def test_kruskal_graph2(self):
        result = self.kruskal_graph2.run_kruskal_algorithm()
        # The MST should have 4 edges with a total weight of 2.
        self.assertEqual(len(result), 4)
        self.assertEqual(sum(edge[2] for edge in result), 2)

    def test_empty_graph(self):
        empty_graph = Kruskal(0)
        result = empty_graph.run_kruskal_algorithm()
        # An empty graph should produce an empty MST.
        self.assertEqual(len(result), 0)
