from py_testgen_app.src.Copilot.Kruskal.BookExampleCode.T9.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):
    def setUp(self):
        self.kruskal = Kruskal(7)
        self.kruskal.add_edge(5, 6, 11)
        self.kruskal.add_edge(0, 1, 7)
        self.kruskal.add_edge(1, 2, 8)
        self.kruskal.add_edge(0, 3, 5)
        self.kruskal.add_edge(1, 3, 9)
        self.kruskal.add_edge(1, 4, 7)
        self.kruskal.add_edge(2, 4, 5)
        self.kruskal.add_edge(3, 4, 15)
        self.kruskal.add_edge(3, 5, 6)
        self.kruskal.add_edge(4, 5, 8)
        self.kruskal.add_edge(4, 6, 9)

    def test_run_kruskal_algorithm(self):
        self.assertEqual(self.kruskal.run_kruskal_algorithm(), [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 4, 7), (0, 1, 7), (4, 6, 9)])

    def test_disjoint_set_make_set(self):
        self.assertEqual(self.kruskal.DisjointSet().make_set(7), None)

    def test_disjoint_set_find(self):
        self.assertEqual(self.kruskal.DisjointSet().find(3), 3)

    def test_disjoint_set_union(self):
        self.assertEqual(self.kruskal.DisjointSet().union(3, 4), None)