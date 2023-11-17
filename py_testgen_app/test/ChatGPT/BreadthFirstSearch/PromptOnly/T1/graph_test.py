from py_testgen_app.src.ChatGPT.BreadthFirstSearch.PromptOnly.T1.graph import Graph

import unittest


class GraphTest(unittest.TestCase):
    def setUp(self):
        from collections import defaultdict

        class Graph:
            def __init__(self, vertices):
                self.graph = defaultdict(list)
                self.vertices = vertices

            def add_edge(self, u, v):
                self.graph[u].append(v)

            def bfs(self, vertex):
                visited = [False] * self.vertices
                queue = []
                result = []

                visited[vertex] = True
                queue.append(vertex)

                while queue:
                    vertex = queue.pop(0)
                    result.append(vertex)

                    for neighbor in self.graph[vertex]:
                        if not visited[neighbor]:
                            visited[neighbor] = True
                            queue.append(neighbor)

                return result

        self.Graph = Graph

    def test_bfs(self):
        self.graph = self.Graph(6)
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

        result = self.graph.bfs(0)
        self.assertEqual(result, [0, 1, 2, 3, 4, 5])

    def test_add_edge(self):
        self.graph = self.Graph(3)
        self.graph.add_edge(0, 1)
        self.graph.add_edge(1, 2)

        self.assertEqual(self.graph.graph, {0: [1], 1: [2], 2: []})

    def test_bfs_different_start(self):
        self.graph = self.Graph(6)
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

        result = self.graph.bfs(3)
        self.assertEqual(result, [3, 1, 2, 4, 5, 0])


