from py_testgen_app.src.ChatGPT.FloydWarshall.PromptOnly.T9.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):

    def setUp(self):
        # Initialize two instances of the FloydWarshall class for testing
        self.floydWarshall1 = FloydWarshall(5)
        self.floydWarshall2 = FloydWarshall(5)

        # Graph 1:
        self.floydWarshall1.add_edge(0, 1, 10)
        self.floydWarshall1.add_edge(0, 3, 5)
        self.floydWarshall1.add_edge(1, 3, 2)
        self.floydWarshall1.add_edge(1, 2, 1)
        self.floydWarshall1.add_edge(2, 4, 4)
        self.floydWarshall1.add_edge(3, 1, 3)
        self.floydWarshall1.add_edge(3, 2, 9)
        self.floydWarshall1.add_edge(3, 4, 2)
        self.floydWarshall1.add_edge(4, 2, 6)

        # Graph 2:
        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

    def test_path_exists(self):
        self.floydWarshall1.run()
        self.assertEqual(self.floydWarshall1.path(0, 4), [0, 3, 4])

    def test_path_does_not_exist(self):
        self.floydWarshall2.run()
        self.assertEqual(self.floydWarshall2.path(0, 1), [])

    def test_same_source_and_destination(self):
        self.floydWarshall1.run()
        self.assertEqual(self.floydWarshall1.path(0, 0), [])
