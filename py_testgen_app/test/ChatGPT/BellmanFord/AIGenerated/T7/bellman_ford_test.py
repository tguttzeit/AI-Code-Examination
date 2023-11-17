from py_testgen_app.src.ChatGPT.BellmanFord.AIGenerated.T7.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):
    def setUp(self):
        self.bellmanFord = BellmanFord(5)  # Assuming 5 vertices for all graphs
        
    def test_graph_1(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {0: 0, 1: -1, 2: 2, 3: -2, 4: 1})

    def test_graph_2(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 4, -2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {0: 0, 1: -1, 2: 2, 3: -1, 4: -3})

    def test_graph_3(self):
        self.bellmanFord.add_edge(0, 0, 1)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(4, 3, 3)

        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {0: 0, 1: 0, 2: 3, 3: 2, 4: 2})
