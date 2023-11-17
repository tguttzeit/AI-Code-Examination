from py_testgen_app.src.ChatGPT.FloydWarshall.PromptOnly.T7.floyd_warshall import FloydWarshall

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

        # Test path from node 0 to node 4
        self.assertEqual(fw.path(0, 4), [0, 3, 4])

        # Test path from node 1 to node 2
        self.assertEqual(fw.path(1, 2), [1, 2])

        # Test path from node 3 to node 0 (no path)
        self.assertIsNone(fw.path(3, 0))

    def test_graph_2(self):
        fw = FloydWarshall(5)
        fw.add_edge(0, 2, 5)
        fw.add_edge(1, 3, 5)
        fw.add_edge(2, 3, 4)
        fw.add_edge(3, 2, 4)
        fw.add_edge(4, 3, 4)
        fw.add_edge(2, 4, -2)
        fw.run()

        # Test path from node 0 to node 3
        self.assertEqual(fw.path(0, 3), [0, 2, 3])

        # Test path from node 1 to node 4
        self.assertEqual(fw.path(1, 4), [1, 3, 2, 4])

        # Test path from node 2 to node 0 (no path)
        self.assertIsNone(fw.path(2, 0))

    def test_empty_graph(self):
        fw = FloydWarshall(0)
        fw.run()

        # Test path in an empty graph (no path)
        self.assertIsNone(fw.path(0, 1))
