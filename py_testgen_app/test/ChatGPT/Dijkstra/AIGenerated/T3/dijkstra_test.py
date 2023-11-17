from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T3.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def test_shortest_paths_graph1(self):
        dijkstra = Dijkstra(5)
        dijkstra.add_edge(0, 1, 1)
        dijkstra.add_edge(0, 2, 4)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(3, 1, 1)
        dijkstra.add_edge(4, 3, 3)

        result = dijkstra.find_shortest_paths(0)
        self.assertEqual(result, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_paths_graph2(self):
        dijkstra = Dijkstra(5)
        dijkstra.add_edge(0, 0, 1)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(4, 3, 3)

        result = dijkstra.find_shortest_paths(0)
        self.assertEqual(result, {1: 0})

    def test_shortest_paths_empty_graph(self):
        dijkstra = Dijkstra(3)

        result = dijkstra.find_shortest_paths(0)
        self.assertEqual(result, {})
