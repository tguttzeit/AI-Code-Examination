from py_testgen_app.src.ChatGPT.DepthFirstSearch.PromptOnly.T7.depth_first_search import DepthFirstSearch

import unittest

class DepthFirstSearchTest(unittest.TestCase):
    def setUp(self):
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

    def test_dfs_starting_from_node_0(self):
        visited_nodes = self.depthFirstSearch.dfs(0)
        self.assertEqual(visited_nodes, [0, 1, 4, 2, 5, 3])

    def test_dfs_starting_from_node_1(self):
        visited_nodes = self.depthFirstSearch.dfs(1)
        self.assertEqual(visited_nodes, [1, 0, 3, 4, 2, 5])

    def test_dfs_starting_from_node_6(self):
        visited_nodes = self.depthFirstSearch.dfs(6)
        self.assertEqual(visited_nodes, [6])
