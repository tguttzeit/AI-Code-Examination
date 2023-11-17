from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T7.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Create a Dijkstra instance for each test case
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for these tests
        # Build Graph 1
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Build Graph 2
        self.dijkstra2 = Dijkstra(5)  # Another instance for Graph 2
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
        result = self.dijkstra2.find_shortest_paths(0)
        self.assertEqual(result, {0: 0, 2: float('inf'), 3: float('inf'), 4: float('inf')})

    def test_shortest_path_nonexistent_vertex(self):
        # Test for a vertex that doesn't exist in Graph 1
        result = self.dijkstra.find_shortest_paths(5)
        self.assertEqual(result, {})
