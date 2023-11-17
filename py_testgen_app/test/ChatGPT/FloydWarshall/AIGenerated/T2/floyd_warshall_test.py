from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T2.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
        # Create FloydWarshall instances for two different graphs
        self.floydWarshall1 = FloydWarshall(5)
        self.floydWarshall2 = FloydWarshall(5)

        # Build Graph 1
        self.floydWarshall1.add_edge(0, 1, 10)
        self.floydWarshall1.add_edge(0, 3, 5)
        self.floydWarshall1.add_edge(1, 3, 2)
        self.floydWarshall1.add_edge(1, 2, 1)
        self.floydWarshall1.add_edge(2, 4, 4)
        self.floydWarshall1.add_edge(3, 1, 3)
        self.floydWarshall1.add_edge(3, 2, 9)
        self.floydWarshall1.add_edge(3, 4, 2)
        self.floydWarshall1.add_edge(4, 2, 6)

        # Build Graph 2
        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

        # Run the algorithm on both graphs
        self.floydWarshall1.run()
        self.floydWarshall2.run()

    def test_shortest_path_1(self):
        # Test shortest path in Graph 1
        self.assertEqual(self.floydWarshall1.path(0, 4), [0, 3, 4])

    def test_shortest_path_2(self):
        # Test shortest path in Graph 2
        self.assertEqual(self.floydWarshall2.path(0, 4), [0, 2, 4])

    def test_shortest_path_no_path(self):
        # Test when there is no path
        self.assertEqual(self.floydWarshall1.path(0, 5), [])
