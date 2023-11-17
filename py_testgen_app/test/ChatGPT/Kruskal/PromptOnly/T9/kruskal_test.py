from py_testgen_app.src.ChatGPT.Kruskal.PromptOnly.T9.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):

    def setUp(self):
        self.graph1 = Kruskal(7)
        self.graph2 = Kruskal(5)
        
        # Graph 1
        self.graph1.add_edge(5, 6, 11)
        self.graph1.add_edge(0, 1, 7)
        self.graph1.add_edge(1, 2, 8)
        self.graph1.add_edge(0, 3, 5)
        self.graph1.add_edge(1, 3, 9)
        self.graph1.add_edge(1, 4, 7)
        self.graph1.add_edge(2, 4, 5)
        self.graph1.add_edge(3, 4, 15)
        self.graph1.add_edge(3, 5, 6)
        self.graph1.add_edge(4, 5, 8)
        self.graph1.add_edge(4, 6, 9)
        
        # Graph 2
        self.graph2.add_edge(0, 1, -3)
        self.graph2.add_edge(0, 4, 1)
        self.graph2.add_edge(4, 1, 4)
        self.graph2.add_edge(2, 1, 9)
        self.graph2.add_edge(2, 4, 3)
        self.graph2.add_edge(4, 3, 2)

    def test_graph1_kruskal(self):
        result = self.graph1.run_kruskal_algorithm()
        expected_result = [(0, 3, 5), (2, 4, 5), (4, 6, 9), (3, 5, 6), (1, 0, 7), (1, 4, 7)]
        self.assertEqual(result, expected_result)

    def test_graph2_kruskal(self):
        result = self.graph2.run_kruskal_algorithm()
        expected_result = [(0, 1, -3), (4, 3, 2), (0, 4, 1), (2, 4, 3)]
        self.assertEqual(result, expected_result)

    def test_invalid_edge(self):
        # Adding an edge with a negative weight to Graph 1 should raise an exception
        with self.assertRaises(ValueError):
            self.graph1.add_edge(2, 3, -10)
