from py_testgen_app.src.Copilot.Kruskal.PromptOnly.T2.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):
    def setUp(self):
        self.kruskal1 = Kruskal(7)
        self.kruskal1.add_edge(5, 6, 11)
        self.kruskal1.add_edge(0, 1, 7)
        self.kruskal1.add_edge(1, 2, 8)
        self.kruskal1.add_edge(0, 3, 5)
        self.kruskal1.add_edge(1, 3, 9)
        self.kruskal1.add_edge(1, 4, 7)
        self.kruskal1.add_edge(2, 4, 5)
        self.kruskal1.add_edge(3, 4, 15)
        self.kruskal1.add_edge(3, 5, 6)
        self.kruskal1.add_edge(4, 5, 8)
        self.kruskal1.add_edge(4, 6, 9)

        self.kruskal2 = Kruskal(5)
        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

        self.kruskal3 = Kruskal(3)
        self.kruskal3.add_edge(0, 1, 1)
        self.kruskal3.add_edge(0, 2, 2)
        self.kruskal3.add_edge(1, 2, 3)

    def test_kruskal1(self):
        expected = [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 4, 7), (4, 6, 9)]
        actual = self.kruskal1.run_kruskal_algorithm()
        self.assertEqual(expected, actual)

    def test_kruskal2(self):
        expected = [(0, 1, -3), (4, 3, 2), (0, 4,