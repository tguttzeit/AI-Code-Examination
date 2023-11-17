from py_testgen_app.src.ChatGPT.Kruskal.AIGenerated.T3.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):

    def setUp(self):
        # Initialize Kruskal instances for each test case
        self.kruskal_graph1 = Kruskal(7)
        self.kruskal_graph2 = Kruskal(5)

        # Build Graph 1
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

        # Build Graph 2
        self.kruskal_graph2.add_edge(0, 1, -3)
        self.kruskal_graph2.add_edge(0, 4, 1)
        self.kruskal_graph2.add_edge(4, 1, 4)
        self.kruskal_graph2.add_edge(2, 1, 9)
        self.kruskal_graph2.add_edge(2, 4, 3)
        self.kruskal_graph2.add_edge(4, 3, 2)

    def test_kruskal_algorithm_graph1(self):
        result = self.kruskal_graph1.run_kruskal_algorithm()
        # Test whether the minimum spanning tree contains the expected edges and weights
        expected_result = [[0, 3, 5], [3, 5, 6], [1, 4, 7], [2, 4, 5], [4, 6, 9], [0, 1, 7]]
        self.assertEqual(result, expected_result)

    def test_kruskal_algorithm_graph2(self):
        result = self.kruskal_graph2.run_kruskal_algorithm()
        # Test whether the minimum spanning tree contains the expected edges and weights
        expected_result = [[0, 1, -3], [0, 4, 1], [4, 3, 2], [2, 4, 3]]
        self.assertEqual(result, expected_result)

    def test_empty_graph(self):
        # Test an empty graph, which should result in an empty minimum spanning tree
        empty_graph = Kruskal(0)
        result = empty_graph.run_kruskal_algorithm()
        self.assertEqual(result, [])
