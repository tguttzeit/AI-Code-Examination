from py_testgen_app.src.Copilot.BellmanFord.AIGenerated.T5.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):
    def setUp(self):
        self.bellmanFord = BellmanFord(5)
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

    def test_bellman_ford(self):
        self.assertEqual(self.bellmanFord.bellman_ford(0), {0: 0, 1: -1, 2: 2, 3: -2, 4: 1})

    def test_bellman_ford2(self):
        self.bellmanFord2 = BellmanFord(5)
        self.bellmanFord2.add_edge(0, 1, -1)
        self.bellmanFord2.add_edge(0, 2, 4)
        self.bellmanFord2.add_edge(1, 2, 3)
        self.bellmanFord2.add_edge(1, 4, -2)
        self.bellmanFord2.add_edge(3, 2, 5)
        self.bellmanFord2.add_edge(3, 1, 1)
        self.bellmanFord2.add_edge(4, 3, -3)
        self.assertEqual(self.bellmanFord2.bellman_ford(0), {0: 0, 1: -1, 2: 2, 3: -2, 4: -2})

    def test_bellman_ford3(self):
        self.bellmanFord3 = BellmanFord(5)
        self.bellmanFord3.add_edge(0, 0, 1)
        self.bellmanFord3.add_edge(1, 2, 3)
        self.bellmanFord3.add_edge(1, 3, 2)
        self.bellmanFord3.add_edge(1, 4, 2)
        self.bellmanFord3.add_edge(3, 0, 0)