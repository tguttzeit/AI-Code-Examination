from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T6.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):
    def setUp(self):
        # Initialize the Dijkstra object for each test case
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for these graphs

        # Graph 1:
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Graph 2:
        self.dijkstra2 = Dijkstra(5)
        self.dijkstra2.add_edge(0, 0, 1)
        self.dijkstra2.add_edge(1, 2, 3)
        self.dijkstra2.add_edge(1, 3, 2)
        self.dijkstra2.add_edge(1, 4, 2)
        self.dijkstra2.add_edge(3, 2, 5)
        self.dijkstra2.add_edge(4, 3, 3)

    def test_shortest_path_graph1(self):
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(shortest_paths, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        shortest_paths = self.dijkstra2.find_shortest_paths(0)
        self.assertEqual(shortest_paths, {0: 0, 1: float('inf'), 2: float('inf'), 3: float('inf'), 4: float('inf')})

    def test_shortest_path_invalid_source(self):
        # Test with an invalid source vertex
        shortest_paths = self.dijkstra.find_shortest_paths(10)
        self.assertEqual(shortest_paths, {})
