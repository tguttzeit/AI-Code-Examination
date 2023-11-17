from py_testgen_app.src.Copilot.BellmanFord.PromptOnly.T5.bellman_ford import BellmanFord

import unittest

class BellmanFordTest(unittest.TestCase):
    # Implement the constructor of BellmanFordTest.
    # The constructor should call the constructor of the class BellmanFord and pass the value 5 as the parameter.
    def setUp(self):
        self.bellmanFord = BellmanFord(5)
        pass

    # Implement the test method test_graph1().
    # The method should call the method add_edge() of the class BellmanFord and pass the following parameters:
    # 0, 1, -1
    # 0, 2, 4
    # 1, 2, 3
    # 1, 3, 2
    # 1, 4, 2
    # 3, 1, 1
    # 4, 3, -3
    # The method should then call the method bellman_ford() of the class BellmanFord and pass 0 as the parameter.
    # The method should then test the output of the method bellman_ford() using the assertEqual() method.
    # The expected output is the following dictionary:
    # {1: -1, 2: 2, 3: -2, 4: 1}
    def test_graph1(self):
        self.bellmanFord.add_edge(0, 1, -1)
        self.bellmanFord.add_edge(0, 2, 4)
        self.bellmanFord.add_edge(1, 2, 3)
        self.bellmanFord.add_edge(1, 3, 2)
        self.bellmanFord.add_edge(1, 4, 2)
        self.bellmanFord.add_edge(3, 1, 1)
        self.bellmanFord.add_edge(4, 3, -3)
        self.assertEqual(self.bellmanFord.bellman_ford(0), {1: -1, 2: 2, 3: -2, 4: 1})

    # Implement the test method test_graph2().
    # The method should call the method add_edge() of the class BellmanFord and pass the following parameters:
    # 0, 1, -1
    # 0, 2, 4
    # 1, 2, 3
    # 1, 4, -2
    #