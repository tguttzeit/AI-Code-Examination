from py_testgen_app.src.ChatGPT.BellmanFord.BookExampleCode.T9.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):

    def setUp(self):
        # Create instances of BellmanFord for each test case
        self.bellmanFord1 = BellmanFord(5)
        self.bellmanFord2 = BellmanFord(5)
        self.bellmanFord3 = BellmanFord(2)

        # Graph 1
        self.bellmanFord1.add_edge(0, 1, -1)
        self.bellmanFord1.add_edge(0, 2, 4)
        self.bellmanFord1.add_edge(1, 2, 3)
        self.bellmanFord1.add_edge(1, 3, 2)
        self.bellmanFord1.add_edge(1, 4, 2)
        self.bellmanFord1.add_edge(3, 1, 1)
        self.bellmanFord1.add_edge(4, 3, -3)

        # Graph 2
        self.bellmanFord2.add_edge(0, 1, -1)
        self.bellmanFord2.add_edge(0, 2, 4)
        self.bellmanFord2.add_edge(1, 2, 3)
        self.bellmanFord2.add_edge(1, 4, -2)
        self.bellmanFord2.add_edge(3, 2, 5)
        self.bellmanFord2.add_edge(3, 1, 1)
        self.bellmanFord2.add_edge(4, 3, -3)

        # Graph 3
        self.bellmanFord3.add_edge(0, 0, 1)
        self.bellmanFord3.add_edge(1, 2, 3)
        self.bellmanFord3.add_edge(1, 3, 2)
        self.bellmanFord3.add_edge(1, 4, 2)
        self.bellmanFord3.add_edge(3, 2, 5)
        self.bellmanFord3.add_edge(4, 3, 3)

    def test_shortest_path_graph1(self):
        # Test the Bellman-Ford algorithm for Graph 1
        result = self.bellmanFord1.bellman_ford(0)
        expected_result = {0: 0, 1: -1, 2: 2, 3: 0, 4: -1}
        self.assertEqual(result, expected_result)

    def test_shortest_path_graph2(self):
        # Test the Bellman-Ford algorithm for Graph 2
        result = self.bellmanFord2.bellman_ford(0)
        expected_result = {0: 0, 1: -1, 2: 2, 3: 0, 4: -3}
        self.assertEqual(result, expected_result)

    def test_shortest_path_graph3(self):
        # Test the Bellman-Ford algorithm for Graph 3
        result = self.bellmanFord3.bellman_ford(0)
        expected_result = {0: 0, 1: float('inf')}
        self.assertEqual(result, expected_result)
