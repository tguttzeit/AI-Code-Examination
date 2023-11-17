from py_testgen_app.src.ChatGPT.DepthFirstSearch.PromptOnly.T1.depth_first_search import DepthFirstSearch

import unittest

class DepthFirstSearchTest(unittest.TestCase):

    def setUp(self):
        # Initialize the DepthFirstSearch instance before each test
        self.depthFirstSearch = DepthFirstSearch()

        # Build the graph with the specified edges
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

    def test_dfs_starting_at_node_0(self):
        result = self.depthFirstSearch.dfs(0)
        expected_result = [0, 1, 4, 2, 5, 3]
        self.assertEqual(result, expected_result)

    def test_dfs_starting_at_node_2(self):
        result = self.depthFirstSearch.dfs(2)
        expected_result = [2, 4, 1, 0, 3, 5]
        self.assertEqual(result, expected_result)

    def test_dfs_starting_at_node_6(self):
        result = self.depthFirstSearch.dfs(6)
        expected_result = [6]
        self.assertEqual(result, expected_result)
