from py_testgen_app.src.Copilot.BellmanFord.AIGenerated.T1.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BellmanFord class for each test case
        self.bellmanFord1 = BellmanFord(5)
        self.bellmanFord2 = BellmanFord(5)
        self.bellmanFord3 = BellmanFord(2)

        # Build Graph 1
        self.bellmanFord1.add_edge(0, 1, -1)
        self.bellmanFord1.add_edge(0, 2, 4)
        self.bellmanFord1.add_edge(1, 2, 3)
        self.bellmanFord1.add_edge(1, 3, 2)
        self.bellmanFord1.add_edge(1, 4, 2)
        self.bellmanFord1.add_edge(3, 1, 1)
        self.bellmanFord1.add_edge(4, 3, -3)

        # Build Graph 2
        self.bellmanFord2.add_edge(0, 1, -1)
        self.bellmanFord2.add_edge(0, 2, 4)
        self.bellmanFord2.add_edge(1, 2, 3)
        self.bellmanFord2.add_edge(1, 4, -2)
        self.bellmanFord2.add_edge(3, 2, 5)
        self.bellmanFord2.add_edge(3, 1, 1)
        self.bellmanFord2.add_edge(4, 3, -3)

        # Build Graph 3
        self.bellmanFord3.add_edge(0, 0, 1)
        self.bellmanFord3.add_edge(1, 2, 3)
        self.bellmanFord3.add_edge(1, 3, 2)
        self.bellmanFord3.add_edge(1, 4, 2)
        self.bellmanFord3.add_edge(3, 2, 5)
        self.bellmanFord3.add_edge(4, 3, 3)

    def test_shortest_paths_graph1(self):
        shortest_paths = self.bellmanFord1.bellman_ford(0)
        self.assertEqual(shortest_paths, {0: 0, 1: -1, 2: 2, 3: 0, 4: -2})

    def test_shortest_paths_graph2(self):
        shortest_paths = self.bellmanFord2.bellman_ford(0)
        self.assertEqual(shortest_paths, {0: 0, 1: -1, 2: 2, 3: 0, 4: -2})

    def test_shortest_paths_graph3(self):
        shortest_paths = self.bellmanFord3.bellman_ford(0)
        self.assertEqual(shortest_paths, {0: 0, 1: float("Inf")})
