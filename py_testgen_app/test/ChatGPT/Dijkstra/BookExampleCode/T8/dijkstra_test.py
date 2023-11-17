from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T8.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Create a Dijkstra instance for each test case
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for both graphs

    def test_shortest_path_graph1(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Find the shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Assert the expected shortest paths
        self.assertEqual(shortest_paths, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        # Find the shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Assert the expected shortest paths
        self.assertEqual(shortest_paths, {0: 0, 2: float('inf'), 3: float('inf'), 4: float('inf')})

    def test_shortest_path_no_edges(self):
        # Test with a graph that has no edges
        self.dijkstra = Dijkstra(3)  # Assuming 3 vertices with no edges

        # Find the shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Assert the expected shortest paths (all inf except for the source vertex)
        self.assertEqual(shortest_paths, {0: 0, 1: float('inf'), 2: float('inf')})
