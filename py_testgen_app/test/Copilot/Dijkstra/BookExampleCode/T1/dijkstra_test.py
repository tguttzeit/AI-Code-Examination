from py_testgen_app.src.Copilot.Dijkstra.BookExampleCode.T1.dijkstra import Dijkstra

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

    def test_graph1(self):
        self.assertEqual(self.dijkstra.find_shortest_paths(0), {1: 1, 2: 4, 3: 3, 4: 3})

    def test_graph2(self):
        self.dijkstra = Dijkstra(5)
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)
        self.assertEqual(self.dijkstra.find_shortest_paths(0), {0: 0, 2: 8, 3: 7, 4: 7})

    def test_graph3(self):
        self.dijkstra = Dijkstra(5)
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)
        self.assertEqual(self.dijkstra.find_shortest_paths(2), {1: 3, 3: 7, 4: 7})

    def test_graph4(self):
        x=0