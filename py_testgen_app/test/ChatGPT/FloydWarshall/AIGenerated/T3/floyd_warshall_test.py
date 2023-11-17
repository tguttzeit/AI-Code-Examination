from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T3.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
        self.graph1 = FloydWarshall(5)
        self.graph1.add_edge(0, 1, 10)
        self.graph1.add_edge(0, 3, 5)
        self.graph1.add_edge(1, 3, 2)
        self.graph1.add_edge(1, 2, 1)
        self.graph1.add_edge(2, 4, 4)
        self.graph1.add_edge(3, 1, 3)
        self.graph1.add_edge(3, 2, 9)
        self.graph1.add_edge(3, 4, 2)
        self.graph1.add_edge(4, 2, 6)
        self.graph1.run()

        self.graph2 = FloydWarshall(5)
        self.graph2.add_edge(0, 2, 5)
        self.graph2.add_edge(1, 3, 5)
        self.graph2.add_edge(2, 3, 4)
        self.graph2.add_edge(3, 2, 4)
        self.graph2.add_edge(4, 3, 4)
        self.graph2.add_edge(2, 4, -2)
        self.graph2.run()

    def test_shortest_path_graph1(self):
        self.assertEqual(self.graph1.path(0, 4), [0, 3, 4])

    def test_shortest_path_graph2(self):
        self.assertEqual(self.graph2.path(0, 3), [0, 2, 3])

    def test_shortest_path_no_path(self):
        self.assertEqual(self.graph1.path(4, 0), [])
