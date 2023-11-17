from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T1.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Initialize a Dijkstra object for each test case
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
        self.dijkstra2 = Dijkstra(5)  # Assuming 5 vertices for both graphs
        self.dijkstra2.add_edge(0, 0, 1)
        self.dijkstra2.add_edge(1, 2, 3)
        self.dijkstra2.add_edge(1, 3, 2)
        self.dijkstra2.add_edge(1, 4, 2)
        self.dijkstra2.add_edge(3, 2, 5)
        self.dijkstra2.add_edge(4, 3, 3)

    def test_shortest_paths_graph1(self):
        source = 0
        expected_result = {1: 1, 2: 4, 3: 3, 4: 3}
        result = self.dijkstra.find_shortest_paths(source)
        self.assertEqual(result, expected_result)

    def test_shortest_paths_graph2(self):
        source = 0
        expected_result = {0: 0, 1: float('inf'), 2: float('inf'), 3: float('inf'), 4: float('inf')}
        result = self.dijkstra2.find_shortest_paths(source)
        self.assertEqual(result, expected_result)

    def test_shortest_paths_graph2_source1(self):
        source = 1
        expected_result = {0: float('inf'), 1: 0, 2: 3, 3: 2, 4: 2}
        result = self.dijkstra2.find_shortest_paths(source)
        self.assertEqual(result, expected_result)
