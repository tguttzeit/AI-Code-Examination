from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T6.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):

    def test_shortest_paths_graph1(self):
        dijkstra = Dijkstra(5)
        dijkstra.add_edge(0, 1, 1)
        dijkstra.add_edge(0, 2, 4)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(3, 1, 1)
        dijkstra.add_edge(4, 3, 3)
        
        shortest_paths = dijkstra.find_shortest_paths(0)
        
        self.assertEqual(shortest_paths, {
            1: [0, 1],
            2: [0, 1, 2],
            3: [0, 1, 3],
            4: [0, 1, 4]
        })

    def test_shortest_paths_graph2(self):
        dijkstra = Dijkstra(5)
        dijkstra.add_edge(0, 0, 1)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(4, 3, 3)
        
        shortest_paths = dijkstra.find_shortest_paths(0)
        
        self.assertEqual(shortest_paths, {
            1: [0, 0, 1],
            2: [0, 0, 1, 2],
            3: [0, 0, 1, 3],
            4: [0, 0, 1, 4]
        })

    def test_no_path(self):
        dijkstra = Dijkstra(3)
        dijkstra.add_edge(0, 1, 1)
        dijkstra.add_edge(1, 2, 2)
        
        shortest_paths = dijkstra.find_shortest_paths(0)
        
        self.assertEqual(shortest_paths, {
            1: [0, 1],
            2: [0, 1, 2]
        })
