from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T4.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):
    def test_graph1_shortest_paths(self):
        self.dijkstra = Dijkstra(5)
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        self.assertEqual(shortest_paths, {
            1: [1],
            2: [1, 2],
            3: [1, 3],
            4: [1, 4]
        })

    def test_graph2_shortest_paths(self):
        self.dijkstra = Dijkstra(5)
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        self.assertEqual(shortest_paths, {
            2: [1, 2],
            3: [1, 3],
            4: [1, 4]
        })

    def test_invalid_source(self):
        self.dijkstra = Dijkstra(5)
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)

        shortest_paths = self.dijkstra.find_shortest_paths(5)  # Invalid source node
        
        self.assertEqual(shortest_paths, {})
