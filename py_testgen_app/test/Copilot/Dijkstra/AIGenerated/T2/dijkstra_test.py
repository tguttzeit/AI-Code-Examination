from py_testgen_app.src.Copilot.Dijkstra.AIGenerated.T2.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):
    def setUp(self):
        self.dijkstra = Dijkstra(5)
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

    def test_find_shortest_paths(self):
        self.assertEqual(self.dijkstra.find_shortest_paths(0), {1: 1, 2: 4, 3: 3, 4: 3})

    def test_find_shortest_paths2(self):
        self.assertEqual(self.dijkstra.find_shortest_paths(1), {0: 1, 2: 3, 3: 2, 4: 2})

    def test_find_shortest_paths3(self):
        self.assertEqual(self.dijkstra.find_shortest_paths(2), {0: 4, 1: 3, 3: 5, 4: 5})