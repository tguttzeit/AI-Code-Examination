from py_app.src.ChatGPT.FloydWarshall.T8.floyd_warshall import FloydWarshall

import unittest


class FloydWarshallTest(unittest.TestCase):

    def test_1(self):
        self.fw = FloydWarshall(5)
        self.fw.add_edge(0, 1, 10)
        self.fw.add_edge(0, 3, 5)
        self.fw.add_edge(1, 3, 2)
        self.fw.add_edge(1, 2, 1)
        self.fw.add_edge(2, 4, 4)
        self.fw.add_edge(3, 1, 3)
        self.fw.add_edge(3, 2, 9)
        self.fw.add_edge(3, 4, 2)
        self.fw.add_edge(4, 2, 6)
        self.fw.run()
        self.assertIn(self.fw.path(0, 0), [[], [0]])
        self.assertEqual([0, 3, 1], self.fw.path(0, 1))
        self.assertEqual([0, 3, 1, 2], self.fw.path(0, 2))
        self.assertEqual([0, 3], self.fw.path(0, 3))
        self.assertEqual([0, 3, 4], self.fw.path(0, 4))
        self.assertEqual([1, 3, 4], self.fw.path(1, 4))

    def test_2(self):
        # Algorithm should run with any number of nodes and with negative weights
        self.fw = FloydWarshall(100)
        self.fw.add_edge(0, 2, 5)
        self.fw.add_edge(1, 3, 5)
        self.fw.add_edge(2, 3, 4)
        self.fw.add_edge(3, 2, 4)
        self.fw.add_edge(4, 3, 4)
        self.fw.add_edge(2, 4, -2)
        self.fw.run()
        self.assertEqual([0, 2, 4, 3], self.fw.path(0, 3))
        self.assertEqual([1, 3, 2, 4], self.fw.path(1, 4))

    # TODO: Test with empty graph


if __name__ == '__main__':
    unittest.main()
