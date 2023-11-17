from py_testgen_app.src.Copilot.DepthFirstSearch.PromptOnly.T9.depth_first_search import DepthFirstSearch

import unittest

class DepthFirstSearchTest(unittest.TestCase):
    def setUp(self):
        self.depthFirstSearch = DepthFirstSearch(7)
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

    # Test that the method dfs() returns the correct list of visited nodes when the parameter "start_node" is 0.
    def test_dfs_0(self):
        self.assertEqual(self.depthFirstSearch.dfs(0), [0, 1, 4, 2, 5, 3])

    # Test that the method dfs() returns the correct list of visited nodes when the parameter "start_node" is 1.
    def test_dfs_1(self):
        self.assertEqual(self.depthFirstSearch.dfs(1), [1, 0, 3, 4, 2, 5])

    # Test that the method dfs() returns the correct list of visited nodes when the parameter "start_node" is 2.
    def test_dfs_2(self):
        self.assertEqual(self.depthFirstSearch.dfs(2), [2, 4, 1, 0, 3, 5])

    # Test that the method dfs() returns the correct list of visited nodes when the parameter "start_node" is 3.
    def test_dfs_3(self):
        self.assertEqual(self.depthFirstSearch.dfs(3), [3, 0, 1, 4, 2, 5])

    # Test that the method dfs() returns the correct list of visited