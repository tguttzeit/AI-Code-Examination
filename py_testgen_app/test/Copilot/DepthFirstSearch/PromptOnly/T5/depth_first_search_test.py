from py_testgen_app.src.Copilot.DepthFirstSearch.PromptOnly.T5.depth_first_search import DepthFirstSearch

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

    def test_dfs_with_0(self):
        self.assertEqual(self.depthFirstSearch.dfs(0), [0, 1, 4, 2, 5, 3])

    def test_dfs_with_1(self):
        self.assertEqual(self.depthFirstSearch.dfs(1), [1, 0, 3, 4, 2, 5])

    def test_dfs_with_2(self):
        self.assertEqual(self.depthFirstSearch.dfs(2), [2, 4, 1, 0, 3, 5])

    def test_dfs_with_3(self):
        self.assertEqual(self.depthFirstSearch.dfs(3), [3, 0, 1, 4, 2, 5])

    def test_dfs_with_4(self):
        self.assertEqual(self.depthFirstSearch.dfs(4), [4, 1, 0, 3, 2, 5])

    def test_dfs_with_5(self):
        self.assertEqual(self.depthFirstSearch.dfs(5), [5, 2, 4, 1, 0, 3])

    def test_dfs_with_6(self):
        self.assertEqual(self.depthFirstSearch.dfs(6), [6])