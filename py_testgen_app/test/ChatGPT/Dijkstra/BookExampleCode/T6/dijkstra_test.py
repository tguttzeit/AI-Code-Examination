from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T6.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Create a Dijkstra instance for testing
        self.dijkstra = Dijkstra(5)

    def test_shortest_path_graph1(self):
        # Build graph 1
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Calculate shortest paths from source vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Check the shortest paths
        self.assertEqual(shortest_paths, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        # Build graph 2
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        # Calculate shortest paths from source vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Check the shortest paths
        self.assertEqual(shortest_paths, {0: 0, 2: 8, 3: 7, 4: 7})

    def test_shortest_path_empty_graph(self):
        # Calculate shortest paths from an empty graph
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Check that no paths are found in an empty graph
        self.assertEqual(shortest_paths, {})
