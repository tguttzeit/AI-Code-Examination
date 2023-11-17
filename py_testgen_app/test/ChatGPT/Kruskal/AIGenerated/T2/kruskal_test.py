from py_testgen_app.src.ChatGPT.Kruskal.AIGenerated.T2.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):
    def setUp(self):
        # Create a Kruskal instance and add edges for each test case
        self.kruskal = Kruskal(7)  # Assuming 7 vertices for both graphs
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
        self.kruskal2 = Kruskal(5)  # Assuming 5 vertices for graph 2
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_algorithm_graph1(self):
        result = self.kruskal.run_kruskal_algorithm()
        # Add your assertions here to check if the result matches the expected MST for Graph 1

    def test_kruskal_algorithm_graph2(self):
        result = self.kruskal2.run_kruskal_algorithm()
        # Add your assertions here to check if the result matches the expected MST for Graph 2

    def test_kruskal_algorithm_empty_graph(self):
        empty_kruskal = Kruskal(0)  # Test with an empty graph
        result = empty_kruskal.run_kruskal_algorithm()
        # Add assertions here to check that the result is an empty list
