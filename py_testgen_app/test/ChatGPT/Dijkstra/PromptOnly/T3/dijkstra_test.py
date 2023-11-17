from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T3.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):

    def test_shortest_paths_graph1(self):
        dijkstra = Dijkstra(5)  # Assuming 5 vertices
        dijkstra.add_edge(0, 1, 1)
        dijkstra.add_edge(0, 2, 4)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(3, 1, 1)
        dijkstra.add_edge(4, 3, 3)

        shortest_paths = dijkstra.find_shortest_paths(0)

        # Assert the expected shortest paths
        expected_paths = {1: [0, 1], 2: [0, 1, 2], 3: [0, 1, 3], 4: [0, 1, 4]}
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_paths_graph2(self):
        dijkstra = Dijkstra(5)  # Assuming 5 vertices
        dijkstra.add_edge(0, 0, 1)
        dijkstra.add_edge(1, 2, 3)
        dijkstra.add_edge(1, 3, 2)
        dijkstra.add_edge(1, 4, 2)
        dijkstra.add_edge(3, 2, 5)
        dijkstra.add_edge(4, 3, 3)

        shortest_paths = dijkstra.find_shortest_paths(0)

        # Assert the expected shortest paths
        expected_paths = {1: [0, 0, 1], 2: [0, 0, 1, 2], 3: [0, 0, 1, 3], 4: [0, 0, 1, 4]}
        self.assertEqual(shortest_paths, expected_paths)

    def test_no_path_same_source_dest(self):
        dijkstra = Dijkstra(5)  # Assuming 5 vertices

        # Add some edges to the graph
        dijkstra.add_edge(0, 1, 1)
        dijkstra.add_edge(0, 2, 4)

        shortest_paths = dijkstra.find_shortest_paths(0)

        # Assert that there are no paths from a node to itself
        for vertex, path in shortest_paths.items():
            self.assertNotEqual(path, [0, 0])

