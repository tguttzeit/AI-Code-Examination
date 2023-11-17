from py_testgen_app.src.Copilot.BreadthFirstSearch.PromptOnly.T5.graph import Graph

import unittest


class GraphTest(unittest.TestCase):

    # Override the setUp() method of the unittest.TestCase class.
    # Create a Graph object with 6 vertices.
    # Add edges to the graph.
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

    # Implement a test case called test_bfs_1() that checks the bfs() method of the Graph class.
    # Call the bfs() method with vertex 2 as parameter.
    # Assert that the returned list is equal to [2, 0, 3, 1, 4, 5].
    def test_bfs_1(self):
        self.assertEqual(self.graph.bfs(2), [2, 0, 3, 1, 4, 5])

    # Implement a test case called test_bfs_2() that checks the bfs() method of the Graph class.
    # Call the bfs() method with vertex 1 as parameter.
    # Assert that the returned list is equal to [1, 0, 3, 2, 4, 5].
    def test_bfs_2(self):
        self.assertEqual(self.graph.bfs(1), [1, 0, 3, 2, 4, 5])

    # Implement a test case called test_bfs_3() that checks the bfs() method of the Graph class.
    # Call the bfs() method with vertex 5 as parameter.
    # Assert that the returned list is equal to [5, 3, 4, 2, 1, 0].
    def test_bfs_3(self):
        self.assertEqual(self.graph.bfs(5), [5, 3, 4, 2, 1, 0])
