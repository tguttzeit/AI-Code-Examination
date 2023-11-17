from py_testgen_app.src.ChatGPT.Kruskal.BookExampleCode.T6.kruskal import Kruskal

import unittest

class TestKruskal(unittest.TestCase):

    def setUp(self):
        # Create an instance of Kruskal for each test case
        self.kruskal1 = Kruskal(7)
        self.kruskal2 = Kruskal(5)

        # Add edges and weights to the first graph
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

        # Add edges and weights to the second graph
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_kruskal_algorithm_graph1(self):
        mst = self.kruskal1.run_kruskal_algorithm()
        expected_mst = [(0, 3, 5), (3, 5, 6), (1, 0, 7), (2, 4, 5), (4, 1, 7), (4, 3, 15)]
        self.assertEqual(sorted(mst), sorted(expected_mst))

    def test_kruskal_algorithm_graph2(self):
        mst = self.kruskal2.run_kruskal_algorithm()
        expected_mst = [(0, 1, -3), (4, 3, 2), (0, 4, 1), (2, 4, 3)]
        self.assertEqual(sorted(mst), sorted(expected_mst))

    def test_empty_graph(self):
        empty_kruskal = Kruskal(0)
        mst = empty_kruskal.run_kruskal_algorithm()
        self.assertEqual(mst, [])

