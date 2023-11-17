from py_testgen_app.src.Copilot.Kruskal.PromptOnly.T1.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):
    def setUp(self):
        self.kruskal = Kruskal(7)
        self.kruskal2 = Kruskal(5)
        self.kruskal3 = Kruskal(7)
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

        self.kruskal2.add_edge(0, 1, -3)
        self.kruskal2.add_edge(0, 4, 1)
        self.kruskal2.add_edge(4, 1, 4)
        self.kruskal2.add_edge(2, 1, 9)
        self.kruskal2.add_edge(2, 4, 3)
        self.kruskal2.add_edge(4, 3, 2)

        self.kruskal3.add_edge(0, 1, 1)
        self.kruskal3.add_edge(0, 2, 1)
        self.kruskal3.add_edge(1, 2, 1)
        self.kruskal3.add_edge(1, 3, 1)
        self.kruskal3.add_edge(2, 3, 1)
        self.kruskal3.add_edge(2, 4, 1)
        self.kruskal3.add_edge(3, 4, 1)
        self.kruskal3.add_edge(3, 5, 1)
        self.kruskal3.add_edge(4, 5, 1)
        self.kruskal3.add_edge(4, 6, 1)

    def test_kruskal(self):
        x=0