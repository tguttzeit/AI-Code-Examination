from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T1.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
        # Initialize the FloydWarshall object for each test case
        self.graph1 = FloydWarshall(5)
        self.graph2 = FloydWarshall(5)

        # Build Graph 1
        self.graph1.add_edge(0, 1, 10)
        self.graph1.add_edge(0, 3, 5)
        self.graph1.add_edge(1, 3, 2)
        self.graph1.add_edge(1, 2, 1)
        self.graph1.add_edge(2, 4, 4)
        self.graph1.add_edge(3, 1, 3)
        self.graph1.add_edge(3, 2, 9)
        self.graph1.add_edge(3, 4, 2)
        self.graph1.add_edge(4, 2, 6)

        # Build Graph 2
        self.graph2.add_edge(0, 2, 5)
        self.graph2.add_edge(1, 3, 5)
        self.graph2.add_edge(2, 3, 4)
        self.graph2.add_edge(3, 2, 4)
        self.graph2.add_edge(4, 3, 4)
        self.graph2.add_edge(2, 4, -2)

        # Run Floyd-Warshall algorithm
        self.graph1.run()
        self.graph2.run()

    def test_shortest_path_graph1(self):
        # Test shortest path from node 0 to node 4 in Graph 1
        self.assertEqual(self.graph1.path(0, 4), [0, 3, 4])

    def test_shortest_path_graph2(self):
        # Test shortest path from node 1 to node 2 in Graph 2
        self.assertEqual(self.graph2.path(1, 2), [1, 3, 2])

    def test_shortest_path_unreachable(self):
        # Test path from node 0 to node 3 in Graph 2 (unreachable)
        self.assertEqual(self.graph2.path(0, 3), [])

