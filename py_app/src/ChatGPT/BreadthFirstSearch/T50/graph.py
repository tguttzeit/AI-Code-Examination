from collections import defaultdict


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def bfs(self, start_vertex):
        visited = [False] * (self.vertices)
        result = []

        queue = [start_vertex]
        visited[start_vertex] = True

        while queue:
            vertex = queue.pop(0)
            result.append(vertex)

            for neighbor in self.graph[vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
