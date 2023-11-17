from py_testgen_app.src.ChatGPT.BellmanFord.PromptOnly.T4.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):
    def setUp(self):
        # Initialize the BellmanFord object for each test case
        self.graph1 = BellmanFord(5)  # Graph 1
        self.graph2 = BellmanFord(5)  # Graph 2
        self.graph3 = BellmanFord(5)  # Graph 3

        # Build Graph 1
        self.graph1.add_edge(0, 1, -1)
        self.graph1.add_edge(0, 2, 4)
        self.graph1.add_edge(1, 2, 3)
        self.graph1.add_edge(1, 3, 2)
        self.graph1.add_edge(1, 4, 2)
        self.graph1.add_edge(3, 1, 1)
        self.graph1.add_edge(4, 3, -3)

        # Build Graph 2
        self.graph2.add_edge(0, 1, -1)
        self.graph2.add_edge(0, 2, 4)
        self.graph2.add_edge(1, 2, 3)
        self.graph2.add_edge(1, 4, -2)
        self.graph2.add_edge(3, 2, 5)
        self.graph2.add_edge(3, 1, 1)
        self.graph2.add_edge(4, 3, -3)

        # Build Graph 3
        self.graph3.add_edge(0, 0, 1)
        self.graph3.add_edge(1, 2, 3)
        self.graph3.add_edge(1, 3, 2)
        self.graph3.add_edge(1, 4, 2)
        self.graph3.add_edge(3, 2, 5)
        self.graph3.add_edge(4, 3, 3)

    def test_shortest_path_graph1(self):
        result = self.graph1.bellman_ford(0)
        self.assertEqual(result[1], -1)
        self.assertEqual(result[2], 2)
        self.assertEqual(result[3], 0)
        self.assertEqual(result[4], 2)

    def test_shortest_path_graph2(self):
        result = self.graph2.bellman_ford(0)
        self.assertEqual(result[1], -1)
        self.assertEqual(result[2], 2)
        self.assertEqual(result[3], -2)
        self.assertEqual(result[4], -4)

    def test_no_negative_cycle_graph3(self):
        result = self.graph3.bellman_ford(0)
        self.assertIsNone(result)
