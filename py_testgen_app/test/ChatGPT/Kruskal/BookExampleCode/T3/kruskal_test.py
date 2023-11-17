from py_testgen_app.src.ChatGPT.Kruskal.BookExampleCode.T3.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):

    def setUp(self):
        # Create Kruskal objects for each test case
        self.kruskal1 = Kruskal(7)
        self.kruskal2 = Kruskal(5)

        # Build the edges for Graph 1
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

        # Build the edges for Graph 2
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_algorithm_graph1(self):
        # Run Kruskal's algorithm on Graph 1
        mst = self.kruskal1.run_kruskal_algorithm()

        # Define the expected MST for Graph 1
        expected_mst = [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 4, 7), (4, 6, 9), (5, 6, 11)]

        # Assert that the computed MST matches the expected MST
        self.assertEqual(mst, expected_mst)

    def test_kruskal_algorithm_graph2(self):
        # Run Kruskal's algorithm on Graph 2
        mst = self.kruskal2.run_kruskal_algorithm()

        # Define the expected MST for Graph 2
        expected_mst = [(0, 1, -3), (4, 3, 2), (0, 4, 1), (2, 4, 3)]

        # Assert that the computed MST matches the expected MST
        self.assertEqual(mst, expected_mst)

    def test_empty_graph(self):
        # Test an empty graph (no edges)
        kruskal_empty = Kruskal(0)
        mst = kruskal_empty.run_kruskal_algorithm()

        # The MST of an empty graph should also be empty
        self.assertEqual(mst, [])
