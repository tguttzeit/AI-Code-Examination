from py_testgen_app.src.ChatGPT.BreadthFirstSearch.AIGenerated.T8.graph import Graph

import unittest

class GraphTest(unittest.TestCase):

    def setUp(self):
        # Create a graph and add the specified edges
        self.graph = Graph(6)
        self.graph.add_edge(0, 1)
        self.graph.add_edge(1, 0)
        self.graph.add_edge(0, 2)
        self.graph.add_edge(2, 0)
        self.graph.add_edge(1, 3)
        self.graph.add_edge(3, 1)
        self.graph.add_edge(2, 3)
        self.graph.add_edge(3, 2)
        self.graph.add_edge(3, 4)
        self.graph.add_edge(4, 3)
        self.graph.add_edge(3, 5)
        self.graph.add_edge(5, 3)

    def test_bfs_starting_from_node_0(self):
        result = self.graph.bfs(0)
        expected_result = [0, 1, 2, 3, 4, 5]
        self.assertEqual(result, expected_result)

    def test_bfs_starting_from_node_1(self):
        result = self.graph.bfs(1)
        expected_result = [1, 0, 3, 2, 4, 5]
        self.assertEqual(result, expected_result)

    def test_bfs_starting_from_node_3(self):
        result = self.graph.bfs(3)
        expected_result = [3, 1, 2, 4, 0, 5]
        self.assertEqual(result, expected_result)

