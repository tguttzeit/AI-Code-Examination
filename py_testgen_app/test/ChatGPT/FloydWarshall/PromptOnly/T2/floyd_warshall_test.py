from py_testgen_app.src.ChatGPT.FloydWarshall.PromptOnly.T2.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):
    def test_graph_1(self):
        fw = FloydWarshall(5)
        fw.add_edge(0, 1, 10)
        fw.add_edge(0, 3, 5)
        fw.add_edge(1, 3, 2)
        fw.add_edge(1, 2, 1)
        fw.add_edge(2, 4, 4)
        fw.add_edge(3, 1, 3)
        fw.add_edge(3, 2, 9)
        fw.add_edge(3, 4, 2)
        fw.add_edge(4, 2, 6)
        fw.run()

        # Test shortest paths
        self.assertEqual(fw.path(0, 1), [0, 3, 1])
        self.assertEqual(fw.path(0, 2), [0, 3, 1, 2])
        self.assertEqual(fw.path(0, 4), [0, 3, 4])
        self.assertEqual(fw.path(1, 0), [1, 3, 0])
        self.assertEqual(fw.path(2, 4), [2, 4])
        self.assertEqual(fw.path(4, 0), [4, 3, 0])

    def test_graph_2(self):
        fw = FloydWarshall(5)
        fw.add_edge(0, 2, 5)
        fw.add_edge(1, 3, 5)
        fw.add_edge(2, 3, 4)
        fw.add_edge(3, 2, 4)
        fw.add_edge(4, 3, 4)
        fw.add_edge(2, 4, -2)
        fw.run()

        # Test shortest paths
        self.assertEqual(fw.path(0, 3), [0, 2, 3])
        self.assertEqual(fw.path(1, 2), [1, 3, 2])
        self.assertEqual(fw.path(3, 1), [3, 2, 4, 1])
        self.assertEqual(fw.path(4, 0), [4, 3, 2, 0])
        self.assertEqual(fw.path(2, 1), [2, 3, 1])
        self.assertEqual(fw.path(2, 4), [2, 4])

    def test_no_path(self):
        fw = FloydWarshall(5)
        fw.add_edge(0, 1, 10)
        fw.add_edge(2, 3, 5)
        fw.run()

        # Test no path and same source/destination
        self.assertEqual(fw.path(0, 2), [])
        self.assertEqual(fw.path(3, 3), [])
