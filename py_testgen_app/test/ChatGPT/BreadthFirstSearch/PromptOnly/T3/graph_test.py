from py_testgen_app.src.ChatGPT.BreadthFirstSearch.PromptOnly.T3.graph import Graph

import unittest


class GraphTest(unittest.TestCase):

    def setUp(self):
        # Create a Graph instance with 6 vertices
        self.graph = Graph(6)

        # Build the graph with the specified edges
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
        # Test BFS starting from vertex 0
        result = self.graph.bfs(0)
        self.assertEqual(result, [0, 1, 2, 3, 4, 5])

    def test_bfs_starting_from_vertex_1(self):
        # Test BFS starting from vertex 1
        result = self.graph.bfs(1)
        self.assertEqual(result, [1, 0, 3, 2, 4, 5])

    def test_bfs_starting_from_vertex_3(self):
        # Test BFS starting from vertex 3
        result = self.graph.bfs(3)
        self.assertEqual(result, [3, 1, 2, 4, 0, 5])


