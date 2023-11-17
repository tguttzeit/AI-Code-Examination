from py_testgen_app.src.Copilot.BreadthFirstSearch.PromptOnly.T1.graph import Graph

import unittest


class GraphTest(unittest.TestCase):
    def setUp(self):
        self.graph = Graph(6)
        self.graph.add_edge(0, 1)
        self.graph.add_edge(1, 0)
        self.graph.add_edge(0, 2)
        self.graph.add_edge(2, 0)
        self.graph.add_edge(1, 3)
        self.graph.add_edge(3, 1)
        self.graph.add_edge(2, 3)
        self.graph.add_edge(3, 2)
        self.graph.add_edge(3, 4)
        self.graph.add_edge(4, 3)
        self.graph.add_edge(3, 5)
        self.graph.add_edge(5, 3)

    # Test case 1: Test the graph with a single vertex.
    # Test case input: 0
    # Expected output: [0]
    def test_graph_1(self):
        self.assertEqual(self.graph.bfs(0), [0])

    # Test case 2: Test the graph with an empty vertex.
    # Test case input: 1
    # Expected output: [1]
    def test_graph_2(self):
        self.assertEqual(self.graph.bfs(1), [1])

    # Test case 3: Test the graph with a single edge.
    # Test case input: 2
    # Expected output: [2]
    def test_graph_3(self):
        self.assertEqual(self.graph.bfs(2), [2])

    # Test case 4: Test the graph with an empty edge.
    # Test case input: 3
    # Expected output: [3]
    def test_graph_4(self):
        self.assertEqual(self.graph.bfs(3), [3])

    # Test case 5: Test the graph with a single vertex and a single edge.
    # Test case input: 4
    # Expected output: [4]
    def test_graph_5(self):
        self.assertEqual(self.graph.bfs(4), [4])

    # Test case 6: Test the graph with a single vertex and an empty edge.
    # Test case input: 5
    # Expected output: [5]
    def test_graph_6(self):
        self.assertEqual(self.graph.bfs(5), [5])

    # Test case 7: Test the graph with a single edge and a single vertex.
    #
