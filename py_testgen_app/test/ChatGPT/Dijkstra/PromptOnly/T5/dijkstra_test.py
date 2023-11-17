from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T5.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):

    def setUp(self):
        # Create a Dijkstra instance for each test case
        self.dijkstra = Dijkstra(5)  # Assuming there are 5 vertices

        # Graph 1 edges and weights
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Graph 2 edges and weights
        self.dijkstra2 = Dijkstra(5)  # Another Dijkstra instance for the second graph
        self.dijkstra2.add_edge(0, 0, 1)
        self.dijkstra2.add_edge(1, 2, 3)
        self.dijkstra2.add_edge(1, 3, 2)
        self.dijkstra2.add_edge(1, 4, 2)
        self.dijkstra2.add_edge(3, 2, 5)
        self.dijkstra2.add_edge(4, 3, 3)

    def test_shortest_paths_graph1(self):
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        expected_paths = {
            1: [0, 1],
            2: [0, 2],
            3: [0, 1, 3],
            4: [0, 1, 4]
        }
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_paths_graph2(self):
        shortest_paths = self.dijkstra2.find_shortest_paths(1)
        expected_paths = {
            0: [1, 0],
            2: [1, 2],
            3: [1, 3],
            4: [1, 4]
        }
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_paths_no_path(self):
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        expected_paths = {
            1: [0, 1],
            2: [0, 2],
            3: [0, 1, 3],
            4: [0, 1, 4]
        }
        self.assertEqual(shortest_paths, expected_paths)
