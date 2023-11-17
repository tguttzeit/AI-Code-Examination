from py_testgen_app.src.Copilot.Dijkstra.PromptOnly.T5.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):
    def setUp(self):
        self.dijkstra = Dijkstra(5)

    def test_find_shortest_paths1(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        self.assertEqual(self.dijkstra.find_shortest_paths(0), {1: 1, 2: 4, 3: 3, 4: 3})
        self.assertEqual(self.dijkstra.find_shortest_paths(1), {0: 1, 2: 3, 3: 2, 4: 2})
        self.assertEqual(self.dijkstra.find_shortest_paths(2), {1: 3, 3: 5, 4: 5})
        self.assertEqual(self.dijkstra.find_shortest_paths(3), {0: 3, 1: 1, 2: 4, 4: 3})
        self.assertEqual(self.dijkstra.find_shortest_paths(4), {1: 2, 3: 3})

    def test_find_shortest_paths2(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        self.assertEqual(self.dijkstra.find_shortest_paths(0), {0: 1})
        self.assertEqual(self.dijkstra.find_shortest_paths(1), {2: 3, 3: 2, 4: 2})
        self.assertEqual(self.dijkstra.find_shortest_paths(2), {})
        self.assertEqual(self.dijkstra.find_shortest_paths(3), {2: 5})