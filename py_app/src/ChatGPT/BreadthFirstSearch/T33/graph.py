from collections import defaultdict


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        if u < 0 or u >= self.vertices or v < 0 or v >= self.vertices:
            raise ValueError("Invalid vertices")
        self.graph[u].append(v)

    def bfs(self, vertex):
        if vertex < 0 or vertex >= self.vertices:
            raise ValueError("Invalid starting vertex")

        visited = [False] * self.vertices
        result = []

        queue = [vertex]
        visited[vertex] = True

        while queue:
            v = queue.pop(0)
            result.append(v)

            for neighbor in self.graph[v]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result

