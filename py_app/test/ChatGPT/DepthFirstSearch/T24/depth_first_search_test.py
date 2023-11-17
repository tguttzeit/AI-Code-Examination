from py_app.src.ChatGPT.DepthFirstSearch.T24.depth_first_search import DepthFirstSearch

import unittest


class DepthFirstSearchTest(unittest.TestCase):

    def setUp(self):
        self.dfs = DepthFirstSearch()

    def test_dfs(self):
        self.dfs.add_edge(0, 1)
        self.dfs.add_edge(1, 0)
        self.dfs.add_edge(0, 3)
        self.dfs.add_edge(3, 0)
        self.dfs.add_edge(1, 4)
        self.dfs.add_edge(4, 1)
        self.dfs.add_edge(2, 4)
        self.dfs.add_edge(4, 2)
        self.dfs.add_edge(2, 5)
        self.dfs.add_edge(5, 2)
        self.dfs.add_edge(3, 1)
        self.dfs.add_edge(1, 3)
        self.dfs.add_edge(4, 3)
        self.dfs.add_edge(3, 4)
        self.dfs.add_edge(5, 5)
        self.dfs.add_edge(6, 6)
        possibility1 = [0, 1, 4, 2, 5, 3]
        possibility2 = [0, 1, 4, 3, 2, 5]
        possibility3 = [0, 1, 3, 4, 2, 5]
        possibility4 = [0, 3, 1, 4, 2, 5]
        possibility5 = [0, 3, 4, 2, 5, 1]
        possibility6 = [0, 3, 4, 1, 2, 5]

        # Start from node 0
        result = self.dfs.dfs(0)
        self.assertTrue(result in (possibility1, possibility2, possibility3, possibility4, possibility5, possibility6))


if __name__ == '__main__':
    unittest.main()
