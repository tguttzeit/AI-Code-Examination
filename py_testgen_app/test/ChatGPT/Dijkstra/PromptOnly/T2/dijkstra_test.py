from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T2.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):

    def test_graph1_shortest_paths(self):
        # Build Graph 1
        dijkstra = Dijkstra(5)
        dijkstra.add_edge(0, 1, 1)
        dijkstra.add_edge(0, 2, 4)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(3, 1, 1)
        dijkstra.add_edge(4, 3, 3)
        
        # Test shortest paths from source node 0
        shortest_paths = dijkstra.find_shortest_paths(0)
        
        expected_paths = {
            1: [0, 1],
            2: [0, 1, 2],
            3: [0, 1, 3],
            4: [0, 1, 4]
        }
        
        self.assertEqual(shortest_paths, expected_paths)

    def test_graph2_shortest_paths(self):
        # Build Graph 2
        dijkstra = Dijkstra(5)
        dijkstra.add_edge(0, 0, 1)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(4, 3, 3)
        
        # Test shortest paths from source node 1
        shortest_paths = dijkstra.find_shortest_paths(1)
        
        expected_paths = {
            2: [1, 2],
            3: [1, 3],
            4: [1, 4]
        }
        
        self.assertEqual(shortest_paths, expected_paths)

    def test_empty_graph(self):
        # Test an empty graph
        dijkstra = Dijkstra(3)
        
        # Test shortest paths from source node 0 in an empty graph
        shortest_paths = dijkstra.find_shortest_paths(0)
        
        expected_paths = {}
        
        self.assertEqual(shortest_paths, expected_paths)
