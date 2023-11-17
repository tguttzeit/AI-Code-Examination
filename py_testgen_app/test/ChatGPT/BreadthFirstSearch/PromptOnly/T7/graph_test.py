from py_testgen_app.src.ChatGPT.BreadthFirstSearch.PromptOnly.T7.graph import Graph

import unittest

# Import the Graph class you want to test here

class GraphTest(unittest.TestCase):

    def setUp(self):
        # Initialize the graph with the given edges
        self.graph = Graph(6)  # 6 vertices
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

    def test_bfs_starting_from_vertex_0(self):
        expected_result = [0, 1, 2, 3, 4, 5]
        result = self.graph.bfs(0)
        self.assertEqual(result, expected_result)

    def test_bfs_starting_from_vertex_1(self):
        expected_result = [1, 0, 3, 2, 4, 5]
        result = self.graph.bfs(1)
        self.assertEqual(result, expected_result)

    def test_bfs_starting_from_vertex_3(self):
        expected_result = [3, 1, 2, 4, 0, 5]
        result = self.graph.bfs(3)
        self.assertEqual(result, expected_result)

