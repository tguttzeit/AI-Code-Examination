from py_testgen_app.src.Copilot.Dijkstra.PromptOnly.T3.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):
    def setUp(self):
        self.dijkstra = Dijkstra(5)

    def test_01(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        expected = {0: {'distance': 0, 'path': [0]}, 1: {'distance': 1, 'path': [0, 1]}, 2: {'distance': 4, 'path': [0, 1, 2]}, 3: {'distance': 3, 'path': [0, 1, 3]}, 4: {'distance': 3, 'path': [0, 1, 4]}}
        actual = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(expected, actual)

    def test_02(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        expected = {0: {'distance': 0, 'path': [0]}, 1: {'distance': 0, 'path': [1]}, 2: {'distance': 3, 'path': [1, 2]}, 3: {'distance': 2, 'path': [1, 3]}, 4: {'distance': 2, 'path': [1, 4]}}
        actual = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(expected, actual)

    def test_03(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 0, 0)