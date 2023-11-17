from py_testgen_app.src.ChatGPT.DepthFirstSearch.PromptOnly.T9.depth_first_search import DepthFirstSearch

import unittest

class DepthFirstSearchTest(unittest.TestCase):
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
        expected_result = [0, 1, 4, 3, 2, 5]
        result = self.depthFirstSearch.dfs(0)
        self.assertEqual(result, expected_result)

    def test_dfs_starting_from_node_1(self):
        expected_result = [1, 0, 4, 3, 2, 5]
        result = self.depthFirstSearch.dfs(1)
        self.assertEqual(result, expected_result)

    def test_dfs_starting_from_node_6(self):
        expected_result = [6]
        result = self.depthFirstSearch.dfs(6)
        self.assertEqual(result, expected_result)

