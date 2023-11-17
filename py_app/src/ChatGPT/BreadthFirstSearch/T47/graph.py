from collections import defaultdict


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        if u < 0 or u >= self.vertices or v < 0 or v >= self.vertices:
            raise ValueError("Invalid vertex")
        self.graph[u].append(v)

    def bfs(self, start_vertex):
        if start_vertex < 0 or start_vertex >= self.vertices:
            raise ValueError("Invalid starting vertex")

        visited = [False] * self.vertices
        queue = []
        result = []

        visited[start_vertex] = True
        queue.append(start_vertex)

        while queue:
            vertex = queue.pop(0)
            result.append(vertex)

            for neighbor in self.graph[vertex]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)

        return result

