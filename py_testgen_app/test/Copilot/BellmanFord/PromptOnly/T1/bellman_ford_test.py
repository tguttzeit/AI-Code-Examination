from py_testgen_app.src.Copilot.BellmanFord.PromptOnly.T1.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):
    def test_graph1(self):
        # Graph 1:
        # self.bellmanFord.add_edge(0, 1, -1)
        # self.bellmanFord.add_edge(0, 2, 4)
        # self.bellmanFord.add_edge(1, 2, 3)
        # self.bellmanFord.add_edge(1, 3, 2)
        # self.bellmanFord.add_edge(1, 4, 2)
        # self.bellmanFord.add_edge(3, 1, 1)
        # self.bellmanFord.add_edge(4, 3, -3)
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 1, -1)
        bellmanFord.add_edge(0, 2, 4)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1, 3, 2)
        bellmanFord.add_edge(1, 4, 2)
        bellmanFord.add_edge(3, 1, 1)
        bellmanFord.add_edge(4, 3, -3)
        self.assertEqual(bellmanFord.bellman_ford(0), {1: -1, 2: 2, 3: -2, 4: 1})

    def test_graph2(self):
        # Graph 2:
        # self.bellmanFord.add_edge(0, 1, -1)
        # self.bellmanFord.add_edge(0, 2, 4)
        # self.bellmanFord.add_edge(1, 2, 3)
        # self.bellmanFord.add_edge(1, 4, -2)
        # self.bellmanFord.add_edge(3, 2, 5)
        # self.bellmanFord.add_edge(3, 1, 1)
        # self.bellmanFord.add_edge(4, 3, -3)
        bellmanFord = BellmanFord(5)
        bellmanFord.add_edge(0, 1, -1)
        bellmanFord.add_edge(0, 2, 4)
        bellmanFord.add_edge(1, 2, 3)
        bellmanFord.add_edge(1,0,0)