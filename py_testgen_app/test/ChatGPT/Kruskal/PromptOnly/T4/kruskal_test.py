from py_testgen_app.src.ChatGPT.Kruskal.PromptOnly.T4.kruskal import Kruskal

import unittest

class KruskalTest(unittest.TestCase):
    def test_graph1(self):
        kruskal = Kruskal(7)
        kruskal.add_edge(5, 6, 11)
        kruskal.add_edge(0, 1, 7)
        kruskal.add_edge(1, 2, 8)
        kruskal.add_edge(0, 3, 5)
        kruskal.add_edge(1, 3, 9)
        kruskal.add_edge(1, 4, 7)
        kruskal.add_edge(2, 4, 5)
        kruskal.add_edge(3, 4, 15)
        kruskal.add_edge(3, 5, 6)
        kruskal.add_edge(4, 5, 8)
        kruskal.add_edge(4, 6, 9)
        
        result = kruskal.run_kruskal_algorithm()
        
        # Expected minimal spanning tree edges
        expected_edges = [(0, 3, 5), (2, 4, 5), (3, 5, 6), (1, 4, 7), (4, 6, 9), (0, 1, 7)]
        
        self.assertEqual(result, expected_edges)
    
    def test_graph2(self):
        kruskal = Kruskal(5)
        kruskal.add_edge(0, 1, -3)
        kruskal.add_edge(0, 4, 1)
        kruskal.add_edge(4, 1, 4)
        kruskal.add_edge(2, 1, 9)
        kruskal.add_edge(2, 4, 3)
        kruskal.add_edge(4, 3, 2)
        
        result = kruskal.run_kruskal_algorithm()
        
        # Expected minimal spanning tree edges
        expected_edges = [(0, 1, -3), (4, 3, 2), (0, 4, 1), (2, 4, 3)]
        
        self.assertEqual(result, expected_edges)
    
    def test_empty_graph(self):
        # Test an empty graph
        kruskal = Kruskal(0)
        
        result = kruskal.run_kruskal_algorithm()
        
        # Expected result is an empty list for an empty graph
        self.assertEqual(result, [])
