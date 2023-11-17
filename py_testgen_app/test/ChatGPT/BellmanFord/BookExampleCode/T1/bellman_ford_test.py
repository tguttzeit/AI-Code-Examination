from py_testgen_app.src.ChatGPT.BellmanFord.BookExampleCode.T1.bellman_ford import BellmanFord

import unittest
import sys

class TestBellmanFord(unittest.TestCase):

    def setUp(self):
        self.graphs = [
            [(0, 1, -1), (0, 2, 4), (1, 2, 3), (1, 3, 2), (1, 4, 2), (3, 1, 1), (4, 3, -3)],
            [(0, 1, -1), (0, 2, 4), (1, 2, 3), (1, 4, -2), (3, 2, 5), (3, 1, 1), (4, 3, -3)],
            [(0, 0, 1), (1, 2, 3), (1, 3, 2), (1, 4, 2), (3, 2, 5), (4, 3, 3)]
        ]

    def test_graph_1(self):
        bf = BellmanFord(5)
        for edge in self.graphs[0]:
            bf.add_edge(*edge)
        results = bf.bellman_ford(0)
        expected = {0: 0, 1: -1, 2: 2, 3: -1, 4: 1}
        self.assertEqual(results, expected)

    def test_graph_2(self):
        bf = BellmanFord(5)
        for edge in self.graphs[1]:
            bf.add_edge(*edge)
        results = bf.bellman_ford(0)
        expected = {0: 0, 1: -1, 2: 2, 3: -2, 4: 1}
        self.assertEqual(results, expected)

    def test_graph_3(self):
        bf = BellmanFord(5)
        for edge in self.graphs[2]:
            bf.add_edge(*edge)
        results = bf.bellman_ford(0)
        expected = {0: 0, 1: sys.maxsize, 2: 3, 3: sys.maxsize, 4: sys.maxsize}
        self.assertEqual(results, expected)
