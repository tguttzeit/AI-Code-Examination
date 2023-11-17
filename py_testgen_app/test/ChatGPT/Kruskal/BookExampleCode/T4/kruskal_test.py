from py_testgen_app.src.ChatGPT.Kruskal.BookExampleCode.T4.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):

    def setUp(self):
        self.kruskal = Kruskal(7)  # Create a Kruskal instance with 7 vertices for both graphs

    def test_graph_1(self):
        # Build Graph 1
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

        # Calculate MST using Kruskal's algorithm
        mst = self.kruskal.run_kruskal_algorithm()

        # Verify that the MST has the expected edges and weight
        expected_mst = [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 0, 7), (4, 1, 7), (4, 6, 9)]
        self.assertEqual(sorted(mst), sorted(expected_mst))

    def test_graph_2(self):
        # Build Graph 2
        self.kruskal.add_edge(0, 1, -3)
        self.kruskal.add_edge(0, 4, 1)
        self.kruskal.add_edge(4, 1, 4)
        self.kruskal.add_edge(2, 1, 9)
        self.kruskal.add_edge(2, 4, 3)
        self.kruskal.add_edge(4, 3, 2)

        # Calculate MST using Kruskal's algorithm
        mst = self.kruskal.run_kruskal_algorithm()

        # Verify that the MST has the expected edges and weight
        expected_mst = [(0, 1, -3), (4, 3, 2), (0, 4, 1), (2, 4, 3)]
        self.assertEqual(sorted(mst), sorted(expected_mst))

    def test_empty_graph(self):
        # Test an empty graph, the MST should also be empty
        mst = self.kruskal.run_kruskal_algorithm()
        self.assertEqual(mst, [])
