from py_testgen_app.src.Copilot.Kruskal.BookExampleCode.T7.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):
    def test_kruskal(self):
        kruskal = Kruskal(7)
        kruskal.add_edge(5, 6, 11)
        kruskal.add_edge(0, 1, 7)
        kruskal.add_edge(1, 2, 8)
        kruskal.add_edge(0, 3, 5)
        kruskal.add_edge(1, 3, 9)
        kruskal.add_edge(1, 4, 7)
        kruskal.add_edge(2, 4, 5)
        kruskal.add_edge(3, 4, 15)
        kruskal.add_edge(3, 5, 6)
        kruskal.add_edge(4, 5, 8)
        kruskal.add_edge(4, 6, 9)
        self.assertEqual(kruskal.run_kruskal_algorithm(), [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 2, 8), (4, 6, 9), (0, 1, 7)])

    def test_kruskal2(self):
        kruskal = Kruskal(5)
        kruskal.add_edge(0, 1, -3)
        kruskal.add_edge(0, 4, 1)
        kruskal.add_edge(4, 1, 4)
        kruskal.add_edge(2, 1, 9)
        kruskal.add_edge(2, 4, 3)
        kruskal.add_edge(4, 3, 2)
        self.assertEqual(kruskal.run_kruskal_algorithm(), [(0, 1, -3), (4, 3, 2), (4, 1, 4), (2, 4, 3)])

    def test_kruskal3(self):
        kruskal = Kruskal(4)
        kruskal.add_edge(0, 1, 1)
        kruskal.add_edge(0, 2, 2)
        kruskal.add_edge(0, 3, 3)
        kruskal.add_edge(1, 2, 4)
        kruskal.add_edge(1, 3