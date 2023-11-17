from py_testgen_app.src.Copilot.Kruskal.AIGenerated.T4.kruskal import Kruskal

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

    def test_kruskal_algorithm(self):
        result = self.kruskal.run_kruskal_algorithm()
        self.assertEqual(result, [[0, 3, 5], [2, 4, 5], [3, 5, 6], [1, 2, 8], [1, 4, 7], [4, 6, 9]])

    def test_kruskal_algorithm2(self):
        self.kruskal = Kruskal(5)
        self.kruskal.add_edge(0, 1, -3)
        self.kruskal.add_edge(0, 4, 1)
        self.kruskal.add_edge(4, 1, 4)
        self.kruskal.add_edge(2, 1, 9)
        self.kruskal.add_edge(2, 4, 3)
        self.kruskal.add_edge(4, 3, 2)
        result = self.kruskal.run_kruskal_algorithm()
        self.assertEqual(result, [[0, 1, -3], [4, 3, 2], [0, 4, 1], [2, 4, 3]])

    def test_kruskal_algorithm3(self):
        self.kruskal = Kruskal(5)
        self.kruskal.add_edge(0, 1, 1)
        self.kruskal.add_edge(0, 2, 3)