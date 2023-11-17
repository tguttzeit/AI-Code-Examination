from py_testgen_app.src.Copilot.BreadthFirstSearch.BookExampleCode.T4.graph import Graph

import unittest


def test1(self):
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
    self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])


def test2(self):
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
    self.assertEqual(self.graph.bfs(3), [3, 1, 2, 4, 5])


def test3(self):
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
    self.assertEqual(self.graph.bfs(
