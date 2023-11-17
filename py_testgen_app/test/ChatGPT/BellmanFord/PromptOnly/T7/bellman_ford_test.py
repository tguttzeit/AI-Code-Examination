from py_testgen_app.src.ChatGPT.BellmanFord.PromptOnly.T7.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):
    def test_graph_1(self):
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 1, -1)
        bellmanFord.add_edge(0, 2, 4)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1, 3, 2)
        bellmanFord.add_edge(1, 4, 2)
        bellmanFord.add_edge(3, 1, 1)
        bellmanFord.add_edge(4, 3, -3)
        
        result = bellmanFord.bellman_ford(0)
        
        expected_result = {1: 0, 2: -1, 3: 2, 4: -2}
        self.assertEqual(result, expected_result)

    def test_graph_2(self):
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 1, -1)
        bellmanFord.add_edge(0, 2, 4)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1, 4, -2)
        bellmanFord.add_edge(3, 2, 5)
        bellmanFord.add_edge(3, 1, 1)
        bellmanFord.add_edge(4, 3, -3)
        
        result = bellmanFord.bellman_ford(0)
        
        expected_result = {1: 0, 2: -1, 3: -3, 4: -3}
        self.assertEqual(result, expected_result)

    def test_graph_3(self):
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 0, 1)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1, 3, 2)
        bellmanFord.add_edge(1, 4, 2)
        bellmanFord.add_edge(3, 2, 5)
        bellmanFord.add_edge(4, 3, 3)
        
        result = bellmanFord.bellman_ford(0)
        
        expected_result = {2: 5, 3: 3, 4: 3}
        self.assertEqual(result, expected_result)
