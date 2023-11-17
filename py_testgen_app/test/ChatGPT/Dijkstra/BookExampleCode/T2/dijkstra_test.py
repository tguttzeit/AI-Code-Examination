from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T2.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Create instances of Dijkstra for Graph 1 and Graph 2
        self.dijkstra_graph1 = Dijkstra(5)
        self.dijkstra_graph2 = Dijkstra(5)

        # Build Graph 1
        self.dijkstra_graph1.add_edge(0, 1, 1)
        self.dijkstra_graph1.add_edge(0, 2, 4)
        self.dijkstra_graph1.add_edge(1, 2, 3)
        self.dijkstra_graph1.add_edge(1, 3, 2)
        self.dijkstra_graph1.add_edge(1, 4, 2)
        self.dijkstra_graph1.add_edge(3, 2, 5)
        self.dijkstra_graph1.add_edge(3, 1, 1)
        self.dijkstra_graph1.add_edge(4, 3, 3)

        # Build Graph 2
        self.dijkstra_graph2.add_edge(0, 0, 1)
        self.dijkstra_graph2.add_edge(1, 2, 3)
        self.dijkstra_graph2.add_edge(1, 3, 2)
        self.dijkstra_graph2.add_edge(1, 4, 2)
        self.dijkstra_graph2.add_edge(3, 2, 5)
        self.dijkstra_graph2.add_edge(4, 3, 3)

    def test_shortest_path_graph1(self):
        # Test shortest paths in Graph 1 starting from vertex 0
        shortest_paths = self.dijkstra_graph1.find_shortest_paths(0)
        self.assertEqual(shortest_paths, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        # Test shortest paths in Graph 2 starting from vertex 0
        shortest_paths = self.dijkstra_graph2.find_shortest_paths(0)
        self.assertEqual(shortest_paths, {0: 0, 1: float('inf'), 2: float('inf'), 3: float('inf'), 4: float('inf')})

    def test_shortest_path_invalid_source(self):
        # Test for an invalid source vertex (out of bounds)
        shortest_paths = self.dijkstra_graph1.find_shortest_paths(5)
        self.assertEqual(shortest_paths, {})
