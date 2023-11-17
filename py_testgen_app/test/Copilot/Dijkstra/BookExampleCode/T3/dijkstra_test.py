from py_testgen_app.src.Copilot.Dijkstra.BookExampleCode.T3.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):
    def setUp(self):
        self.dijkstra = Dijkstra(5)

    def test_graph1(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        result = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(result[1], 1)
        self.assertEqual(result[2], 4)
        self.assertEqual(result[3], 3)
        self.assertEqual(result[4], 3)

    def test_graph2(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        result = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(result[0], 0)
        self.assertEqual(result[1], 1)
        self.assertEqual(result[2], 4)
        self.assertEqual(result[3], 3)
        self.assertEqual(result[4], 3)

    def test_graph3(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        result = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(result[1], 1)
        self.assertEqual(result[2], 4)
        self.assertEqual(result[3], 3)