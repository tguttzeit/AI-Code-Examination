from py_testgen_app.src.ChatGPT.Kruskal.AIGenerated.T4.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):
    def setUp(self):
        # Create Kruskal instances for Graph 1 and Graph 2
        self.kruskal_graph1 = Kruskal(7)
        self.kruskal_graph2 = Kruskal(5)

        # Add edges for Graph 1
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

        # Add edges for Graph 2
        self.kruskal_graph2.add_edge(0, 1, -3)
        self.kruskal_graph2.add_edge(0, 4, 1)
        self.kruskal_graph2.add_edge(4, 1, 4)
        self.kruskal_graph2.add_edge(2, 1, 9)
        self.kruskal_graph2.add_edge(2, 4, 3)
        self.kruskal_graph2.add_edge(4, 3, 2)

    def test_kruskal_graph1(self):
        result = self.kruskal_graph1.run_kruskal_algorithm()
        # Check that the MST contains the expected edges
        expected_edges = [(0, 3, 5), (1, 0, 7), (4, 3, 2), (1, 4, 7), (3, 5, 6), (2, 4, 5)]
        self.assertEqual(sorted(result), sorted(expected_edges))

    def test_kruskal_graph2(self):
        result = self.kruskal_graph2.run_kruskal_algorithm()
        # Check that the MST contains the expected edges
        expected_edges = [(0, 1, -3), (4, 0, 1), (4, 3, 2), (2, 4, 3)]
        self.assertEqual(sorted(result), sorted(expected_edges))

    def test_empty_graph(self):
        # Test an empty graph
        empty_graph = Kruskal(0)
        result = empty_graph.run_kruskal_algorithm()
        self.assertEqual(result, [])
