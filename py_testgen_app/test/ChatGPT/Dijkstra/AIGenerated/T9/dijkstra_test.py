from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T9.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):
    def setUp(self):
        self.graph1 = Dijkstra(5)
        self.graph1.add_edge(0, 1, 1)
        self.graph1.add_edge(0, 2, 4)
        self.graph1.add_edge(1, 2, 3)
        self.graph1.add_edge(1, 3, 2)
        self.graph1.add_edge(1, 4, 2)
        self.graph1.add_edge(3, 2, 5)
        self.graph1.add_edge(3, 1, 1)
        self.graph1.add_edge(4, 3, 3)

        self.graph2 = Dijkstra(5)
        self.graph2.add_edge(0, 0, 1)
        self.graph2.add_edge(1, 2, 3)
        self.graph2.add_edge(1, 3, 2)
        self.graph2.add_edge(1, 4, 2)
        self.graph2.add_edge(3, 2, 5)
        self.graph2.add_edge(4, 3, 3)

    def test_shortest_path_graph1(self):
        result = self.graph1.find_shortest_paths(0)
        self.assertEqual(result, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        result = self.graph2.find_shortest_paths(1)
        self.assertEqual(result, {0: 7, 2: 3, 3: 2, 4: 2})

    def test_shortest_path_invalid_source(self):
        result = self.graph1.find_shortest_paths(6)  # Invalid source vertex
        self.assertEqual(result, {})
