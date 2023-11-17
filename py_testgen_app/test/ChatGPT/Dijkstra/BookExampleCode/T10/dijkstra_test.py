from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T10.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for both graphs
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
        self.dijkstra2.add_edge(0, 0, 1)  # Self-loop edge
        self.dijkstra2.add_edge(1, 2, 3)
        self.dijkstra2.add_edge(1, 3, 2)
        self.dijkstra2.add_edge(1, 4, 2)
        self.dijkstra2.add_edge(3, 2, 5)
        self.dijkstra2.add_edge(4, 3, 3)

    def test_shortest_paths_graph1(self):
        result = self.dijkstra.find_shortest_paths(0)
        self.assertEqual(result, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_paths_graph2(self):
        result = self.dijkstra2.find_shortest_paths(0)
        self.assertEqual(result, {0: 0, 1: 10000000, 2: 10000000, 3: 10000000, 4: 10000000})

    def test_shortest_paths_graph1_source_3(self):
        result = self.dijkstra.find_shortest_paths(3)
        self.assertEqual(result, {0: 10000000, 1: 10000000, 2: 10000000, 4: 3})
