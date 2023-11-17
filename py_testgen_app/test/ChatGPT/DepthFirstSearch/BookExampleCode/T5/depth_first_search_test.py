from py_testgen_app.src.ChatGPT.DepthFirstSearch.BookExampleCode.T5.depth_first_search import DepthFirstSearch

import unittest
class TestDepthFirstSearch(unittest.TestCase):

    def setUp(self):
        self.depthFirstSearch = DepthFirstSearch()
        self.depthFirstSearch.add_edge(0, 1)
        self.depthFirstSearch.add_edge(1, 0)
        self.depthFirstSearch.add_edge(0, 3)
        self.depthFirstSearch.add_edge(3, 0)
        self.depthFirstSearch.add_edge(1, 4)
        self.depthFirstSearch.add_edge(4, 1)
        self.depthFirstSearch.add_edge(2, 4)
        self.depthFirstSearch.add_edge(4, 2)
        self.depthFirstSearch.add_edge(2, 5)
        self.depthFirstSearch.add_edge(5, 2)
        self.depthFirstSearch.add_edge(3, 1)
        self.depthFirstSearch.add_edge(1, 3)
        self.depthFirstSearch.add_edge(4, 3)
        self.depthFirstSearch.add_edge(3, 4)
        self.depthFirstSearch.add_edge(5, 5)
        self.depthFirstSearch.add_edge(6, 6)

    def test_dfs_starting_from_node_0(self):
        result = self.depthFirstSearch.dfs(0)
        self.assertEqual(result, [0, 1, 4, 2, 5, 3, 6])

    def test_dfs_starting_from_node_1(self):
        result = self.depthFirstSearch.dfs(1)
        self.assertEqual(result, [1, 0, 3, 4, 2, 5, 6])

    def test_dfs_starting_from_node_2(self):
        result = self.depthFirstSearch.dfs(2)
        self.assertEqual(result, [2, 4, 1, 0, 3, 5, 6])
