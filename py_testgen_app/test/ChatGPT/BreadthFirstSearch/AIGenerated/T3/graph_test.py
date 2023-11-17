from py_testgen_app.src.ChatGPT.BreadthFirstSearch.AIGenerated.T3.graph import Graph

import unittest

class GraphTest(unittest.TestCase):

    def test_bfs_single_source(self):
        g = Graph(6)
        g.add_edge(0, 1)
        g.add_edge(1, 0)
        g.add_edge(0, 2)
        g.add_edge(2, 0)
        g.add_edge(1, 3)
        g.add_edge(3, 1)
        g.add_edge(2, 3)
        g.add_edge(3, 2)
        g.add_edge(3, 4)
        g.add_edge(4, 3)
        g.add_edge(3, 5)
        g.add_edge(5, 3)

        expected_result = [0, 1, 2, 3, 4, 5]
        self.assertEqual(g.bfs(0), expected_result)

    def test_bfs_disconnected_graph(self):
        g = Graph(5)
        g.add_edge(0, 1)
        g.add_edge(1, 0)
        g.add_edge(2, 3)
        g.add_edge(3, 2)
        g.add_edge(3, 4)
        g.add_edge(4, 3)

        expected_result = [0, 1]
        self.assertEqual(g.bfs(0), expected_result)

    def test_bfs_empty_graph(self):
        g = Graph(0)
        expected_result = []
        self.assertEqual(g.bfs(0), expected_result)


