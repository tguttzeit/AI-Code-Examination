from py_testgen_app.src.Copilot.BellmanFord.AIGenerated.T7.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):
    def setUp(self):
        self.bellmanFord = BellmanFord(5)

    def test_graph_1(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)
        self.assertEqual(self.bellmanFord.bellman_ford(0), {0: 0, 1: -1, 2: 2, 3: -2, 4: 1})
        self.assertEqual(self.bellmanFord.bellman_ford(1), {1: 0, 2: 3, 3: -1, 4: 2, 0: -1})
        self.assertEqual(self.bellmanFord.bellman_ford(2), {2: 0, 3: 4, 4: 5, 0: 4, 1: 3})
        self.assertEqual(self.bellmanFord.bellman_ford(3), {3: 0, 4: 1, 0: 5, 1: 4, 2: 7})
        self.assertEqual(self.bellmanFord.bellman_ford(4), {4: 0, 0: 1, 1: 2, 2: 5, 3: 2})

    def test_graph_2(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 4, -2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, 0)