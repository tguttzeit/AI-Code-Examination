from py_testgen_app.src.Copilot.BreadthFirstSearch.PromptOnly.T4.graph import Graph

import unittest

class GraphTest(unittest.TestCase):

    def setUp(self):
        self.graph = Graph(6)
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

    # Test case 1
    # Test the constructor
    # Call the constructor with the parameter 6
    # Check that the constructor does not raise an exception
    def test_constructor(self):
        try:
            Graph(6)
        except:
            self.fail("Graph constructor raised ExceptionType unexpectedly!")

    # Test case 2
    # Test the add_edge() method
    # Call the add_edge() method with the parameters 0 and 1
    # Check that the add_edge() method does not raise an exception
    def test_add_edge(self):
        try:
            self.graph.add_edge(0, 1)
        except:
            self.fail("Graph add_edge raised ExceptionType unexpectedly!")

    # Test case 3
    # Test the bfs() method
    # Call the bfs() method with the parameter 0
    # Check that the bfs() method returns the list [0, 1, 2, 3, 4, 5]
    def test_bfs(self):
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])
