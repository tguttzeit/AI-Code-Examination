from py_testgen_app.src.ChatGPT.BreadthFirstSearch.BookExampleCode.T7.graph import Graph

import unittest

class GraphTest(unittest.TestCase):
    def test_bfs_single_node(self):
        # Test BFS with a single node graph
        graph = Graph(1)
        result = graph.bfs(0)
        self.assertEqual(result, [0])

    def test_bfs_disconnected_graph(self):
        # Test BFS on a disconnected graph
        graph = Graph(6)
        graph.add_edge(0, 1)
        graph.add_edge(2, 3)
        result = graph.bfs(0)
        self.assertEqual(result, [0, 1])

    def test_bfs_connected_graph(self):
        # Test BFS on a connected graph
        graph = Graph(5)
        graph.add_edge(0, 1)
        graph.add_edge(0, 2)
        graph.add_edge(1, 3)
        graph.add_edge(2, 4)
        result = graph.bfs(0)
        self.assertEqual(result, [0, 1, 2, 3, 4])


