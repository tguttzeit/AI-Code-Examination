from py_testgen_app.src.ChatGPT.BellmanFord.BookExampleCode.T4.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):

    def test_graph1(self):
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 1, -1)
        bellmanFord.add_edge(0, 2, 4)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1, 3, 2)
        bellmanFord.add_edge(1, 4, 2)
        bellmanFord.add_edge(3, 1, 1)
        bellmanFord.add_edge(4, 3, -3)

        expected_result = {0: 0, 1: -1, 2: 2, 3: -2, 4: 1}
        self.assertEqual(bellmanFord.bellman_ford(0), expected_result)

    def test_graph2(self):
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 1, -1)
        bellmanFord.add_edge(0, 2, 4)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1, 4, -2)
        bellmanFord.add_edge(3, 2, 5)
        bellmanFord.add_edge(3, 1, 1)
        bellmanFord.add_edge(4, 3, -3)

        expected_result = {0: 0, 1: -1, 2: 2, 3: -2, 4: -3}
        self.assertEqual(bellmanFord.bellman_ford(0), expected_result)

    def test_graph3(self):
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 0, 1)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1, 3, 2)
        bellmanFord.add_edge(1, 4, 2)
        bellmanFord.add_edge(3, 2, 5)
        bellmanFord.add_edge(4, 3, 3)

        expected_result = {0: 0, 1: 1, 2: 4, 3: 3, 4: 3}
        self.assertEqual(bellmanFord.bellman_ford(0), expected_result)
