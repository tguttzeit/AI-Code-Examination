from py_testgen_app.src.ChatGPT.FloydWarshall.PromptOnly.T6.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):

    def setUp(self):
        # Create instances of FloydWarshall for two different graphs
        self.floydWarshall1 = FloydWarshall(5)
        self.floydWarshall2 = FloydWarshall(5)

        # Graph 1
        self.floydWarshall1.add_edge(0, 1, 10)
        self.floydWarshall1.add_edge(0, 3, 5)
        self.floydWarshall1.add_edge(1, 3, 2)
        self.floydWarshall1.add_edge(1, 2, 1)
        self.floydWarshall1.add_edge(2, 4, 4)
        self.floydWarshall1.add_edge(3, 1, 3)
        self.floydWarshall1.add_edge(3, 2, 9)
        self.floydWarshall1.add_edge(3, 4, 2)
        self.floydWarshall1.add_edge(4, 2, 6)

        # Graph 2
        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

    def test_path(self):
        # Test path from source 0 to destination 4 in graph 1
        self.assertEqual(self.floydWarshall1.path(0, 4), [0, 3, 4])

        # Test path from source 2 to destination 3 in graph 2
        self.assertEqual(self.floydWarshall2.path(2, 3), [2, 3])

        # Test path from source 4 to destination 1 in graph 1
        self.assertEqual(self.floydWarshall1.path(4, 1), [])

    def test_run(self):
        # Run Floyd-Warshall algorithm on both graphs
        self.floydWarshall1.run()
        self.floydWarshall2.run()

        # Test shortest distance between nodes
        self.assertEqual(self.floydWarshall1.path(0, 4), 7)
        self.assertEqual(self.floydWarshall2.path(1, 4), float('inf'))

        # Test shortest distance between nodes in the same graph
        self.assertEqual(self.floydWarshall1.path(2, 4), 4)
        self.assertEqual(self.floydWarshall2.path(2, 3), 4)
