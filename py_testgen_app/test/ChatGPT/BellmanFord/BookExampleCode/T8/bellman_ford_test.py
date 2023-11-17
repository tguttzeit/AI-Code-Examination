from py_testgen_app.src.ChatGPT.BellmanFord.BookExampleCode.T8.bellman_ford import BellmanFord

import unittest

class TestBellmanFord(unittest.TestCase):

    def setUp(self):
        self.graph1 = BellmanFord(5)
        self.graph1.add_edge(0, 1, -1)
        self.graph1.add_edge(0, 2, 4)
        self.graph1.add_edge(1, 2, 3)
        self.graph1.add_edge(1, 3, 2)
        self.graph1.add_edge(1, 4, 2)
        self.graph1.add_edge(3, 1, 1)
        self.graph1.add_edge(4, 3, -3)

        self.graph2 = BellmanFord(5)
        self.graph2.add_edge(0, 1, -1)
        self.graph2.add_edge(0, 2, 4)
        self.graph2.add_edge(1, 2, 3)
        self.graph2.add_edge(1, 4, -2)
        self.graph2.add_edge(3, 2, 5)
        self.graph2.add_edge(3, 1, 1)
        self.graph2.add_edge(4, 3, -3)

        self.graph3 = BellmanFord(5)
        self.graph3.add_edge(0, 0, 1)
        self.graph3.add_edge(1, 2, 3)
        self.graph3.add_edge(1, 3, 2)
        self.graph3.add_edge(1, 4, 2)
        self.graph3.add_edge(3, 2, 5)
        self.graph3.add_edge(4, 3, 3)

    def test_graph1(self):
        result = self.graph1.bellman_ford(0)
        self.assertEqual(result, {1: -1, 2: 2, 3: 4, 4: 0})

    def test_graph2(self):
        result = self.graph2.bellman_ford(0)
        self.assertEqual(result, {1: -1, 2: 2, 4: -1, 3: 0})

    def test_graph3(self):
        result = self.graph3.bellman_ford(0)
        self.assertEqual(result, {0: 0, 2: 5, 3: 4, 4: 6, 1: 1})

