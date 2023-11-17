from py_testgen_app.src.ChatGPT.FloydWarshall.BookExampleCode.T1.floyd_warshall import FloydWarshall
import unittest

class TestFloydWarshall(unittest.TestCase):

    def setUp(self):
        # Initialize the FloydWarshall instance for each test case
        self.floydWarshall = FloydWarshall(5)  # 5 nodes for both graphs

    def test_graph1(self):
        # Build Graph 1
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        # Run the Floyd-Warshall algorithm
        self.floydWarshall.run()

        # Verify specific distances
        self.assertEqual(self.floydWarshall.distance[0][2], 8)
        self.assertEqual(self.floydWarshall.distance[1][4], 10)

    def test_graph2(self):
        # Build Graph 2
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

        # Run the Floyd-Warshall algorithm
        self.floydWarshall.run()

        # Verify specific distances
        self.assertEqual(self.floydWarshall.distance[0][1], float('inf'))
        self.assertEqual(self.floydWarshall.distance[1][0], float('inf'))
        self.assertEqual(self.floydWarshall.distance[0][2], 5)
        self.assertEqual(self.floydWarshall.distance[2][0], float('inf'))
        self.assertEqual(self.floydWarshall.distance[1][2], float('inf'))
        self.assertEqual(self.floydWarshall.distance[2][1], float('inf'))
        self.assertEqual(self.floydWarshall.distance[3][4], float('inf'))

    def test_emptyGraph(self):
        # Test an empty graph (no edges)
        self.floydWarshall.run()

        # Verify specific distances
        self.assertEqual(self.floydWarshall.distance[0][0], 0)
        self.assertEqual(self.floydWarshall.distance[1][1], 0)
        self.assertEqual(self.floydWarshall.distance[2][2], 0)