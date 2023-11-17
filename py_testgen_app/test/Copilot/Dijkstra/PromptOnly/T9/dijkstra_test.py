from py_testgen_app.src.Copilot.Dijkstra.PromptOnly.T9.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):
    def setUp(self):
        self.dijkstra = Dijkstra(5)

    def test_find_shortest_paths_1(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(shortest_paths, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_find_shortest_paths_2(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)
        shortest_paths = self.dijkstra.find_shortest_paths(1)
        self.assertEqual(shortest_paths, {2: 3, 3: 2, 4: 2})

    def test_find_shortest_paths_3(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)
        shortest_paths = self.dijkstra.find_shortest_paths(3)
        self.assertEqual(shortest_paths, {2: 5})

    def test_add_edge_1(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)