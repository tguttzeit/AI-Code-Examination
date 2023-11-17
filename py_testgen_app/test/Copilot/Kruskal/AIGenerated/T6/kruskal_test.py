from py_testgen_app.src.Copilot.Kruskal.AIGenerated.T6.kruskal import Kruskal

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
        self.kruskal2 = Kruskal(5)
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

    def test_graph1(self):
        self.assertEqual(self.kruskal.run_kruskal_algorithm(), [[0, 3, 5], [2, 4, 5], [3, 5, 6], [1, 2, 8], [1, 4, 7], [4, 6, 9]])

    def test_graph2(self):
        self.assertEqual(self.kruskal2.run_kruskal_algorithm(), [[0, 1, -3], [4, 3, 2], [0, 4, 1], [2, 4, 3]])

    def test_graph3(self):
        self.kruskal3 = Kruskal(6)
        self.kruskal3.add_edge(0, 1, 4)
        self.kruskal3.add_edge(0, 2, 3)
        self.kruskal3