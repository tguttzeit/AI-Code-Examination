from py_testgen_app.src.Copilot.DepthFirstSearch.PromptOnly.T3.depth_first_search import DepthFirstSearch

import unittest

class DepthFirstSearchTest(unittest.TestCase):
    # Create a setUp() method to create an instance of DepthFirstSearch and
    # build the graph with the following edges:
    # self.depthFirstSearch.add_edge(0, 1)
    # self.depthFirstSearch.add_edge(1, 0)
    # self.depthFirstSearch.add_edge(0, 3)
    # self.depthFirstSearch.add_edge(3, 0)
    # self.depthFirstSearch.add_edge(1, 4)
    # self.depthFirstSearch.add_edge(4, 1)
    # self.depthFirstSearch.add_edge(2, 4)
    # self.depthFirstSearch.add_edge(4, 2)
    # self.depthFirstSearch.add_edge(2, 5)
    # self.depthFirstSearch.add_edge(5, 2)
    # self.depthFirstSearch.add_edge(3, 1)
    # self.depthFirstSearch.add_edge(1, 3)
    # self.depthFirstSearch.add_edge(4, 3)
    # self.depthFirstSearch.add_edge(3, 4)
    # self.depthFirstSearch.add_edge(5, 5)
    # self.depthFirstSearch.add_edge(6, 6)
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

    # Create a test case to test the dfs() method with the parameter 0 and the expected result [0,
