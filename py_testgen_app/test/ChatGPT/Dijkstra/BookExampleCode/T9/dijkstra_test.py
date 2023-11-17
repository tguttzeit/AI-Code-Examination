from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T9.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Create a Dijkstra instance for testing
        self.dijkstra = Dijkstra(5)

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
        self.dijkstra2 = Dijkstra(5)
        self.dijkstra2.add_edge(0, 0, 1)
        self.dijkstra2.add_edge(1, 2, 3)
        self.dijkstra2.add_edge(1, 3, 2)
        self.dijkstra2.add_edge(1, 4, 2)
        self.dijkstra2.add_edge(3, 2, 5)
        self.dijkstra2.add_edge(4, 3, 3)

    def test_shortest_paths_graph1(self):
        # Test shortest paths for Graph 1
        source = 0
        expected_paths = {1: 1, 2: 4, 3: 3, 4: 3}
        self.assertEqual(self.dijkstra.find_shortest_paths(source), expected_paths)

    def test_shortest_paths_graph2(self):
        # Test shortest paths for Graph 2
        source = 0
        expected_paths = {0: 0, 1: 1, 2: float('inf'), 3: float('inf'), 4: float('inf')}
        self.assertEqual(self.dijkstra2.find_shortest_paths(source), expected_paths)

    def test_shortest_paths_invalid_source(self):
        # Test shortest paths with an invalid source node
        source = 6
        self.assertRaises(IndexError, self.dijkstra.find_shortest_paths, source)
