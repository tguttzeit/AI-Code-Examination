from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T2.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):
    def setUp(self):
        # Create instances of Dijkstra for each test case
        self.dijkstra1 = Dijkstra(5)
        self.dijkstra2 = Dijkstra(5)

        # Build Graph 1
        self.dijkstra1.add_edge(0, 1, 1)
        self.dijkstra1.add_edge(0, 2, 4)
        self.dijkstra1.add_edge(1, 2, 3)
        self.dijkstra1.add_edge(1, 3, 2)
        self.dijkstra1.add_edge(1, 4, 2)
        self.dijkstra1.add_edge(3, 2, 5)
        self.dijkstra1.add_edge(3, 1, 1)
        self.dijkstra1.add_edge(4, 3, 3)

        # Build Graph 2
        self.dijkstra2.add_edge(0, 0, 1)
        self.dijkstra2.add_edge(1, 2, 3)
        self.dijkstra2.add_edge(1, 3, 2)
        self.dijkstra2.add_edge(1, 4, 2)
        self.dijkstra2.add_edge(3, 2, 5)
        self.dijkstra2.add_edge(4, 3, 3)

    def test_shortest_path_graph1(self):
        shortest_paths = self.dijkstra1.find_shortest_paths(0)
        self.assertEqual(shortest_paths, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        shortest_paths = self.dijkstra2.find_shortest_paths(0)
        self.assertEqual(shortest_paths, {1: 0, 2: 3, 3: 2, 4: 2})

    def test_shortest_path_invalid_source(self):
        with self.assertRaises(IndexError):
            self.dijkstra1.find_shortest_paths(6)
