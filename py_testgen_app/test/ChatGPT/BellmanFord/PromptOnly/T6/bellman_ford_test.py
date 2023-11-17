from py_testgen_app.src.ChatGPT.BellmanFord.PromptOnly.T6.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):

    def setUp(self):
        # Initialize the BellmanFord object for each test case
        self.bellmanFord = BellmanFord(5)

    def test_graph1(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        result = self.bellmanFord.bellman_ford(0)
        
        expected = {
            1: -1,
            2: 2,
            3: 0,
            4: 2
        }
        self.assertEqual(result, expected)

    def test_graph2(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 4, -2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

        result = self.bellmanFord.bellman_ford(0)
        
        expected = {
            1: -1,
            2: 2,
            4: -1,
            3: 0
        }
        self.assertEqual(result, expected)

    def test_graph3(self):
        self.bellmanFord.add_edge(0, 0, 1)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 2, 5)
        self.bellmanFord.add_edge(4, 3, 3)

        result = self.bellmanFord.bellman_ford(0)
        
        # Since there is a loop from node 0 to itself, it should be skipped in the output
        expected = {
            1: 0,
            2: 3,
            3: 2,
            4: 2
        }
        self.assertEqual(result, expected)
