from py_testgen_app.src.ChatGPT.FloydWarshall.PromptOnly.T1.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):

    def setUp(self):
        # Create instances of FloydWarshall for Graph 1 and Graph 2
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

    def test_path_exists(self):
        # Test if a valid path exists in Graph 1
        self.graph1.run()
        self.assertEqual(self.graph1.path(0, 4), [0, 3, 4])

    def test_no_path(self):
        # Test when there is no path from source to destination in Graph 2
        self.graph2.run()
        self.assertIsNone(self.graph2.path(0, 1))

    def test_same_node(self):
        # Test when source and destination are the same in Graph 1
        self.graph1.run()
        self.assertIsNone(self.graph1.path(2, 2))
