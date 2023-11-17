from py_testgen_app.src.Copilot.BellmanFord.BookExampleCode.T8.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):
    def setUp(self):
        self.bellmanFord = BellmanFord(5)
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)

    def tearDown(self):
        del self.bellmanFord

    def test_bellman_ford(self):
        self.assertEqual(self.bellmanFord.bellman_ford(0), {1: -1, 2: 2, 3: -2, 4: 1})

    def test_bellman_ford2(self):
        self.assertEqual(self.bellmanFord.bellman_ford(1), {2: 3, 3: 1, 4: 3})

    def test_bellman_ford3(self):
        self.assertEqual(self.bellmanFord.bellman_ford(2), {})

    def test_bellman_ford4(self):
        self.assertEqual(self.bellmanFord.bellman_ford(3), {1: 1, 2: 4, 4: 6})

    def test_bellman_ford5(self):
        self.assertEqual(self.bellmanFord.bellman_ford(4), {1: 3, 2: 6, 3: 4})

    def test_bellman_ford6(self):
        self.assertEqual(self.bellmanFord.bellman_ford(5), {})

    def test_bellman_ford7(self):
        self.assertEqual(self.bellmanFord.bellman_ford(6), {})

    def test_bellman_ford8(self):
        self.assertEqual(self.bellmanFord.bellman_ford(7), {})

    def test_bellman_ford9(self):
        self.assertEqual(self.bellmanFord.bellman_ford(8), {})

    def test_bellman_ford10(self):
        self.assertEqual(self.bellmanFord