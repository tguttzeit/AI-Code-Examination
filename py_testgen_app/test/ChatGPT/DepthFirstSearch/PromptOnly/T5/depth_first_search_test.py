from py_testgen_app.src.ChatGPT.DepthFirstSearch.PromptOnly.T5.depth_first_search import DepthFirstSearch

import unittest

class DepthFirstSearchTest(unittest.TestCase):
    def setUp(self):
        # Create an instance of the DepthFirstSearch class and build the graph as specified.
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

    def test_add_edge(self):
        # Test if the add_edge method correctly adds edges to the graph.
        self.assertTrue((0, 1) in self.depthFirstSearch.graph)
        self.assertTrue((1, 0) in self.depthFirstSearch.graph)
        self.assertTrue((6, 6) in self.depthFirstSearch.graph)

    def test_dfs(self):
        # Test the dfs method for correctness with different starting nodes.
        # Test Case 1: Starting from node 0
        result1 = self.depthFirstSearch.dfs(0)
        self.assertEqual(result1, [0, 1, 4, 2, 5, 3, 6])

        # Test Case 2: Starting from node 2
        result2 = self.depthFirstSearch.dfs(2)
        self.assertEqual(result2, [2, 4, 1, 0, 3, 5, 6])

        # Test Case 3: Starting from node 6
        result3 = self.depthFirstSearch.dfs(6)
        self.assertEqual(result3, [6])
