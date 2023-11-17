from py_testgen_app.src.Copilot.Kruskal.AIGenerated.T2.kruskal import Kruskal

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
        self.assertEqual(result[0], [0, 3, 5])
        self.assertEqual(result[1], [2, 4, 5])
        self.assertEqual(result[2], [3, 5, 6])
        self.assertEqual(result[3], [1, 2, 8])
        self.assertEqual(result[4], [1, 4, 7])
        self.assertEqual(result[5], [4, 6, 9])

    def test_kruskal_algorithm2(self):
        self.kruskal = Kruskal(5)
        self.kruskal.add_edge(0, 1, -3)
        self.kruskal.add_edge(0, 4, 1)
        self.kruskal.add_edge(4, 1, 4)
        self.kruskal.add_edge(2, 1, 9)
        self.kruskal.add_edge(2, 4, 3)
        self.kruskal.add_edge(4, 3, 2)
        result = self.kruskal.run_kruskal_algorithm()
        self.assertEqual(result[0], [0, 1, -3])
        self.assertEqual(result[1], [4, 3, 2])
        self.assertEqual(result[2], [4, 1, 4])