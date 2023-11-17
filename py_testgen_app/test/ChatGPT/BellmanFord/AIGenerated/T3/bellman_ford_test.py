from py_testgen_app.src.ChatGPT.BellmanFord.AIGenerated.T3.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):
    def setUp(self):
        self.bellmanFord = BellmanFord(5)  # Assuming 5 vertices for all test cases
        # Graph 1
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)
        
        # Graph 2
        self.bellmanFord2 = BellmanFord(5)
        self.bellmanFord2.add_edge(0, 1, -1)
        self.bellmanFord2.add_edge(0, 2, 4)
        self.bellmanFord2.add_edge(1, 2, 3)
        self.bellmanFord2.add_edge(1, 4, -2)
        self.bellmanFord2.add_edge(3, 2, 5)
        self.bellmanFord2.add_edge(3, 1, 1)
        self.bellmanFord2.add_edge(4, 3, -3)

        # Graph 3
        self.bellmanFord3 = BellmanFord(5)
        self.bellmanFord3.add_edge(0, 0, 1)
        self.bellmanFord3.add_edge(1, 2, 3)
        self.bellmanFord3.add_edge(1, 3, 2)
        self.bellmanFord3.add_edge(1, 4, 2)
        self.bellmanFord3.add_edge(3, 2, 5)
        self.bellmanFord3.add_edge(4, 3, 3)

    def test_graph1(self):
        result = self.bellmanFord.bellman_ford(0)
        expected = {0: 0, 1: -1, 2: 2, 3: -1, 4: 1}
        self.assertEqual(result, expected)

    def test_graph2(self):
        result = self.bellmanFord2.bellman_ford(0)
        expected = {0: 0, 1: -1, 2: 0, 3: 2, 4: -1}
        self.assertEqual(result, expected)

    def test_graph3(self):
        result = self.bellmanFord3.bellman_ford(0)
        expected = {0: 0, 1: 0, 2: 3, 3: 2, 4: 2}
        self.assertEqual(result, expected)
