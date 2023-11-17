from py_testgen_app.src.Copilot.Dijkstra.PromptOnly.T1.dijkstra import Dijkstra

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

    def test_shortest_path_1(self):
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(shortest_paths[1], 1)
        self.assertEqual(shortest_paths[2], 4)
        self.assertEqual(shortest_paths[3], 3)
        self.assertEqual(shortest_paths[4], 3)

    def test_shortest_path_2(self):
        shortest_paths = self.dijkstra.find_shortest_paths(1)
        self.assertEqual(shortest_paths[0], 1)
        self.assertEqual(shortest_paths[2], 3)
        self.assertEqual(shortest_paths[3], 2)
        self.assertEqual(shortest_paths[4], 2)

    def test_shortest_path_3(self):
        shortest_paths = self.dijkstra.find_shortest_paths(2)
        self.assertEqual(shortest_paths[0], 4)
        self.assertEqual(shortest_paths[1], 3)
        self.assertEqual(shortest_paths[3], 5)
        self.assertEqual(shortest_paths[4], 5)

    def test_shortest_path_4(self):
        shortest_paths = self.dijkstra.find_shortest_paths(3)
        self.assertEqual(shortest_paths[0], 3)
        self.assertEqual(shortest_paths[1], 1)
        self.assertEqual(shortest_paths[2], 5)
        self.assertEqual(shortest_paths[4], 3)

    def test_shortest_path_5(self):
        shortest_paths = self.dijkstra.find_shortest_paths(4)
        self.assertEqual(shortest_paths[0], 3)
        self.assertEqual(shortest_paths[1], 2)
        self.assertEqual(shortest_paths[2], 6)
        self.assertEqual(shortest_paths[3], 3)

    def test_short(self):
        x=0