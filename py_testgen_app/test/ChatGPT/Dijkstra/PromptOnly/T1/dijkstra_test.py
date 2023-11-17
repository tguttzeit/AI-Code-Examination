from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T1.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):

    def setUp(self):
        # Create instances of the Dijkstra class for two different graphs
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

    def test_shortest_paths_graph1(self):
        shortest_paths = self.dijkstra_graph1.find_shortest_paths(0)
        expected_paths = {1: [0, 1], 2: [0, 2], 3: [0, 1, 3], 4: [0, 1, 4]}
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_paths_graph2(self):
        shortest_paths = self.dijkstra_graph2.find_shortest_paths(1)
        expected_paths = {2: [1, 2], 3: [1, 3], 4: [1, 4]}
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_paths_invalid_source(self):
        shortest_paths = self.dijkstra_graph1.find_shortest_paths(5)  # Source not in the graph
        expected_paths = {}
        self.assertEqual(shortest_paths, expected_paths)
