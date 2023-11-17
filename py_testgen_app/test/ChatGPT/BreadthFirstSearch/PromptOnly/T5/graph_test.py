from py_testgen_app.src.ChatGPT.BreadthFirstSearch.PromptOnly.T5.graph import Graph

import unittest

class GraphTest(unittest.TestCase):
    def setUp(self):
        # Create a graph with the specified edges
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

    def test_bfs(self):
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])
        self.assertEqual(self.graph.bfs(1), [1, 0, 3, 2, 4, 5])
        self.assertEqual(self.graph.bfs(3), [3, 1, 2, 0, 4, 5])

    def test_add_edge(self):
        # Test if adding an edge updates the adjacency list correctly
        self.graph.add_edge(0, 4)
        self.assertEqual(self.graph, [[1, 2, 4], [0, 3], [0, 3], [1, 2, 4, 5], [3], [3]])

    def test_invalid_bfs(self):
        # Test bfs with an invalid starting vertex
        with self.assertRaises(IndexError):
            self.graph.bfs(6)

