from py_testgen_app.src.Copilot.BreadthFirstSearch.AIGenerated.T1.graph import Graph

import unittest

class GraphTest(unittest.TestCase):
    def setUp(self):
        self.graph = Graph(5)
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

    # Test case 1: start_vertex is 0
    def test_bfs1(self):
        result = self.graph.bfs(0)
        self.assertEqual(result, [0, 1, 2, 3, 4, 5])

    # Test case 2: start_vertex is 1
    def test_bfs2(self):
        result = self.graph.bfs(1)
        self.assertEqual(result, [1, 0, 3, 2, 4, 5])

    # Test case 3: start_vertex is 2
    def test_bfs3(self):
        result = self.graph.bfs(2)
        self.assertEqual(result, [2, 0, 3, 1, 4, 5])

    # Test case 4: start_vertex is 3
    def test_bfs4(self):
        result = self.graph.bfs(3)
        self.assertEqual(result, [3, 1, 2, 4, 5, 0])

    # Test case 5: start_vertex is 4
    def test_bfs5(self):
        result = self.graph.bfs(4)
        self.assertEqual(result, [4, 3, 5, 1, 2, 0])

    # Test case 6: start_vertex is 5
    def test_bfs6(self):
        result = self.graph.bfs(5)
        self.assertEqual(result, [5, 3, 4, 1, 2, 0])

    # Test case 7: start_vertex is 6
    def test_bfs7(self):
        result = self.graph.bfs(6)
