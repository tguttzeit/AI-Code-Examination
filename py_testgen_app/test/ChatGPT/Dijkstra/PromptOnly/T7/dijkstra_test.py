from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T7.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):

    def setUp(self):
        # Create a Dijkstra instance for each test case
        self.graph1 = Dijkstra(5)
        self.graph2 = Dijkstra(5)

        # Graph 1 edges and weights
        self.graph1.add_edge(0, 1, 1)
        self.graph1.add_edge(0, 2, 4)
        self.graph1.add_edge(1, 2, 3)
        self.graph1.add_edge(1, 3, 2)
        self.graph1.add_edge(1, 4, 2)
        self.graph1.add_edge(3, 2, 5)
        self.graph1.add_edge(3, 1, 1)
        self.graph1.add_edge(4, 3, 3)

        # Graph 2 edges and weights
        self.graph2.add_edge(0, 0, 1)
        self.graph2.add_edge(1, 2, 3)
        self.graph2.add_edge(1, 3, 2)
        self.graph2.add_edge(1, 4, 2)
        self.graph2.add_edge(3, 2, 5)
        self.graph2.add_edge(4, 3, 3)

    def test_shortest_paths_graph1(self):
        result = self.graph1.find_shortest_paths(0)
        self.assertEqual(result, {1: (0, 1), 2: (0, 4), 3: (3, 6), 4: (1, 3)})

    def test_shortest_paths_graph2(self):
        result = self.graph2.find_shortest_paths(1)
        self.assertEqual(result, {2: (3, 3), 3: (2, 2), 4: (2, 2)})

    def test_no_path_same_node(self):
        result = self.graph1.find_shortest_paths(0)
        self.assertNotIn(0, result)
