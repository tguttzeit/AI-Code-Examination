from py_testgen_app.src.ChatGPT.BellmanFord.AIGenerated.T5.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):
    def setUp(self):
        self.bellmanFord = BellmanFord(5)  # Assuming 5 vertices for all test cases
        self.graphs = [
            [[0, 1, -1], [0, 2, 4], [1, 2, 3], [1, 3, 2], [1, 4, 2], [3, 1, 1], [4, 3, -3]],
            [[0, 1, -1], [0, 2, 4], [1, 2, 3], [1, 4, -2], [3, 2, 5], [3, 1, 1], [4, 3, -3]],
            [[0, 0, 1], [1, 2, 3], [1, 3, 2], [1, 4, 2], [3, 2, 5], [4, 3, 3]]
        ]

    def test_graph_1(self):
        for edge in self.graphs[0]:
            self.bellmanFord.add_edge(edge[0], edge[1], edge[2])
        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {0: 0, 1: -1, 2: 2, 3: -2, 4: 1})

    def test_graph_2(self):
        for edge in self.graphs[1]:
            self.bellmanFord.add_edge(edge[0], edge[1], edge[2])
        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {0: 0, 1: -1, 2: 2, 3: 1, 4: -1})

    def test_graph_3(self):
        for edge in self.graphs[2]:
            self.bellmanFord.add_edge(edge[0], edge[1], edge[2])
        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {0: 0})
