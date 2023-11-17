from py_testgen_app.src.ChatGPT.BreadthFirstSearch.PromptOnly.T2.graph import Graph

import unittest


class GraphTest(unittest.TestCase):
    def setUp(self):
        from collections import defaultdict
        from queue import Queue

        class Graph:
            def __init__(self, vertices):
                self.vertices = vertices
                self.graph = defaultdict(list)

            def add_edge(self, u, v):
                self.graph[u].append(v)

            def bfs(self, start):
                visited = [False] * self.vertices
                result = []
                queue = Queue()
                queue.put(start)
                visited[start] = True

                while not queue.empty():
                    vertex = queue.get()
                    result.append(vertex)

                    for neighbor in self.graph[vertex]:
                        if not visited[neighbor]:
                            queue.put(neighbor)
                            visited[neighbor] = True

                return result

        self.Graph = Graph
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

    def test_bfs_starting_from_node_0(self):
        expected_result = [0, 1, 2, 3, 4, 5]
        self.assertEqual(self.graph.bfs(0), expected_result)

    def test_bfs_starting_from_node_1(self):
        expected_result = [1, 0, 3, 2, 4, 5]
        self.assertEqual(self.graph.bfs(1), expected_result)

    def test_bfs_starting_from_node_3(self):
        expected_result = [3, 1, 2, 0, 4, 5]
        self.assertEqual(self.graph.bfs(3), expected_result)

