from py_testgen_app.src.ChatGPT.BreadthFirstSearch.PromptOnly.T8.graph import Graph

import unittest

class GraphTest(unittest.TestCase):
    def setUp(self):
        # Create a new Graph instance for each test case
        self.graph = Graph(6)  # Assuming 6 vertices for this test

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

    def test_bfs(self):
        # Test BFS on various vertices
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])
        self.assertEqual(self.graph.bfs(1), [1, 0, 3, 2, 4, 5])
        self.assertEqual(self.graph.bfs(3), [3, 1, 2, 0, 4, 5])

    def test_add_edge(self):
        # Test if add_edge correctly adds edges
        self.assertEqual(len(self.graph.bfs(0)), 6)  # Before adding an edge
        self.graph.add_edge(0, 4)
        self.assertEqual(len(self.graph.bfs(0)), 6)  # After adding an edge

    def test_invalid_vertex(self):
        # Test behavior when using an invalid vertex
        with self.assertRaises(ValueError):
            self.graph.bfs(10)  # Vertex 10 does not exist in the graph

