from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T8.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):
    def setUp(self):
        # Create an instance of the Dijkstra class for testing
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

    def test_shortest_path_graph1_from_source0(self):
        result = self.dijkstra.find_shortest_paths(0)
        expected = {1: 1, 2: 4, 3: 3, 4: 3}
        self.assertEqual(result, expected)

    def test_shortest_path_graph1_from_source1(self):
        result = self.dijkstra.find_shortest_paths(1)
        expected = {0: 1, 2: 3, 3: 2, 4: 2}
        self.assertEqual(result, expected)

    def test_shortest_path_graph2_from_source1(self):
        result = self.dijkstra2.find_shortest_paths(1)
        expected = {0: 1, 2: 3, 3: 2, 4: 2}
        self.assertEqual(result, expected)
