from py_testgen_app.src.ChatGPT.BellmanFord.BookExampleCode.T3.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):

    def setUp(self):
        self.bellmanFord = BellmanFord(5)  # Assuming there are 5 vertices in all graphs.

    def test_graph_1(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        results = self.bellmanFord.bellman_ford(0)

        expected_results = {1: -1, 2: 2, 3: 0, 4: 2}
        self.assertEqual(results, expected_results)

    def test_graph_2(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 4, -2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        results = self.bellmanFord.bellman_ford(0)

        expected_results = {1: -1, 2: 2, 3: 0, 4: -2}
        self.assertEqual(results, expected_results)

    def test_graph_3(self):
        self.bellmanFord.add_edge(0, 0, 1)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(4, 3, 3)

        results = self.bellmanFord.bellman_ford(0)

        expected_results = {0: 0, 1: 1, 2: 3, 3: 3, 4: 3}
        self.assertEqual(results, expected_results)
