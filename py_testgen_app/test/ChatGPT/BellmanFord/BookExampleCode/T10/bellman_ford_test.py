from py_testgen_app.src.ChatGPT.BellmanFord.BookExampleCode.T10.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):

    def setUp(self):
        self.bellmanFord = BellmanFord(5)  # Create a BellmanFord instance with 5 vertices

    def test_graph1(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {1: -1, 2: 2, 3: 0, 4: -2})

    def test_graph2(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 4, -2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {1: -1, 2: 2, 3: 0, 4: -2})

    def test_graph3(self):
        self.bellmanFord.add_edge(0, 0, 1)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(4, 3, 3)

        result = self.bellmanFord.bellman_ford(0)
        self.assertEqual(result, {0: 0, 1: 1, 2: 4, 3: 3, 4: 3})
