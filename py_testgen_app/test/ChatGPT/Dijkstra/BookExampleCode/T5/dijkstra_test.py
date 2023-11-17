from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T5.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Create a Dijkstra object for testing
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

    def test_shortest_path_graph1(self):
        result = self.dijkstra.find_shortest_paths(0)
        expected = {1: 1, 2: 4, 3: 3, 4: 3}
        self.assertEqual(result, expected)

    def test_shortest_path_graph2(self):
        # Create a new Dijkstra object for Graph 2
        dijkstra2 = Dijkstra(5)
        dijkstra2.add_edge(0, 0, 1)
        dijkstra2.add_edge(1, 2, 3)
        dijkstra2.add_edge(1, 3, 2)
        dijkstra2.add_edge(1, 4, 2)
        dijkstra2.add_edge(3, 2, 5)
        dijkstra2.add_edge(4, 3, 3)
        
        result = dijkstra2.find_shortest_paths(0)
        expected = {0: 0, 2: float('inf'), 3: float('inf'), 4: float('inf')}
        self.assertEqual(result, expected)

    def test_shortest_path_invalid_source(self):
        result = self.dijkstra.find_shortest_paths(5)  # Invalid source
        expected = {}
        self.assertEqual(result, expected)
