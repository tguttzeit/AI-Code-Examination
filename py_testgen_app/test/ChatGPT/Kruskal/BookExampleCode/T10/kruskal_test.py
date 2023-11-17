from py_testgen_app.src.ChatGPT.Kruskal.BookExampleCode.T10.kruskal import Kruskal

import unittest

class TestKruskalAlgorithm(unittest.TestCase):
    def setUp(self):
        # Create a Kruskal instance for each test case
        self.kruskal1 = Kruskal(7)
        self.kruskal2 = Kruskal(5)

        # Build the first graph
        self.kruskal1.add_edge(5, 6, 11)
        self.kruskal1.add_edge(0, 1, 7)
        self.kruskal1.add_edge(1, 2, 8)
        self.kruskal1.add_edge(0, 3, 5)
        self.kruskal1.add_edge(1, 3, 9)
        self.kruskal1.add_edge(1, 4, 7)
        self.kruskal1.add_edge(2, 4, 5)
        self.kruskal1.add_edge(3, 4, 15)
        self.kruskal1.add_edge(3, 5, 6)
        self.kruskal1.add_edge(4, 5, 8)
        self.kruskal1.add_edge(4, 6, 9)

        # Build the second graph
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_algorithm_graph1(self):
        # Calculate MST using Kruskal's algorithm for graph 1
        mst = self.kruskal1.run_kruskal_algorithm()
        # Verify that the MST contains the expected number of edges
        self.assertEqual(len(mst), 6)

        # Verify that the total weight of the MST is correct
        total_weight = sum(edge[2] for edge in mst)
        self.assertEqual(total_weight, 39)

    def test_kruskal_algorithm_graph2(self):
        # Calculate MST using Kruskal's algorithm for graph 2
        mst = self.kruskal2.run_kruskal_algorithm()
        # Verify that the MST contains the expected number of edges
        self.assertEqual(len(mst), 4)

        # Verify that the total weight of the MST is correct
        total_weight = sum(edge[2] for edge in mst)
        self.assertEqual(total_weight, 2)

    def test_empty_graph(self):
        # Test an empty graph
        kruskal = Kruskal(0)
        mst = kruskal.run_kruskal_algorithm()
        # An empty graph should result in an empty MST
        self.assertEqual(len(mst), 0)
