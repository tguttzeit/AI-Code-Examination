from py_app.src.ChatGPT.BreadthFirstSearch.T10.graph import Graph

import unittest


class GraphTest(unittest.TestCase):

    def setUp(self):
        self.sut = Graph(6)

    def test_should_return_correct_parent_array(self):
        # Create an unordered graph
        self.sut.add_edge(0, 1)
        self.sut.add_edge(1, 0)
        self.sut.add_edge(0, 2)
        self.sut.add_edge(2, 0)
        self.sut.add_edge(1, 3)
        self.sut.add_edge(3, 1)
        self.sut.add_edge(2, 3)
        self.sut.add_edge(3, 2)
        self.sut.add_edge(3, 4)
        self.sut.add_edge(4, 3)
        self.sut.add_edge(3, 5)
        self.sut.add_edge(5, 3)

        possibility1 = [0, 2, 1, 3, 4, 5]
        possibility2 = [0, 2, 1, 3, 5, 4]
        possibility3 = [0, 1, 2, 3, 4, 5]
        possibility4 = [0, 1, 2, 3, 5, 4]
        expected = True
        actual = self.sut.bfs(0) in (possibility1, possibility2, possibility3, possibility4)

        self.assertEqual(expected, actual)

    # TODO: Test with empty graph

if __name__ == '__main__':
    unittest.main()
