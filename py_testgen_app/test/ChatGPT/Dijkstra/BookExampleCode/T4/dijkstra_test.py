from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T4.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        self.dijkstra = Dijkstra(5)  # Initialize Dijkstra with 5 vertices

        # Graph 1
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Graph 2
        self.dijkstra2 = Dijkstra(5)  # Initialize a second Dijkstra object for Graph 2
        self.dijkstra2.add_edge(0, 0, 1)
        self.dijkstra2.add_edge(1, 2, 3)
        self.dijkstra2.add_edge(1, 3, 2)
        self.dijkstra2.add_edge(1, 4, 2)
        self.dijkstra2.add_edge(3, 2, 5)
        self.dijkstra2.add_edge(4, 3, 3)

    def test_shortest_path_graph1(self):
        result = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(result, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        result = self.dijkstra2.find_shortest_paths(1)
        self.assertEqual(result, {0: 1, 2: 3, 3: 2, 4: 2})

    def test_no_path(self):
        self.dijkstra2.add_edge(0, 1, 0)  # Adding an edge with weight 0 (no path)
        result = self.dijkstra2.find_shortest_paths(0)
        self.assertEqual(result, {2: 1e7, 3: 1e7, 4: 1e7})
