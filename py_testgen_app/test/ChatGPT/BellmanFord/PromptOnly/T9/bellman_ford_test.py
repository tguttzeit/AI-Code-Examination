from py_testgen_app.src.ChatGPT.BellmanFord.PromptOnly.T9.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):

    def test_graph_1(self):
        graph = BellmanFord(5)
        graph.add_edge(0, 1, -1)
        graph.add_edge(0, 2, 4)
        graph.add_edge(1, 2, 3)
        graph.add_edge(1, 3, 2)
        graph.add_edge(1, 4, 2)
        graph.add_edge(3, 1, 1)
        graph.add_edge(4, 3, -3)

        result = graph.bellman_ford(0)
        expected = {1: -1, 2: 2, 3: -2, 4: 1}
        self.assertEqual(result, expected)

    def test_graph_2(self):
        graph = BellmanFord(5)
        graph.add_edge(0, 1, -1)
        graph.add_edge(0, 2, 4)
        graph.add_edge(1, 2, 3)
        graph.add_edge(1, 4, -2)
        graph.add_edge(3, 2, 5)
        graph.add_edge(3, 1, 1)
        graph.add_edge(4, 3, -3)

        result = graph.bellman_ford(0)
        expected = {1: -1, 2: 2, 3: -2, 4: -3}
        self.assertEqual(result, expected)

    def test_graph_3(self):
        graph = BellmanFord(5)
        graph.add_edge(0, 0, 1)
        graph.add_edge(1, 2, 3)
        graph.add_edge(1, 3, 2)
        graph.add_edge(1, 4, 2)
        graph.add_edge(3, 2, 5)
        graph.add_edge(4, 3, 3)

        result = graph.bellman_ford(0)
        expected = {1: 1}
        self.assertEqual(result, expected)
