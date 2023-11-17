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
            raise ValueError("Invalid start vertex")

        visited = [False] * self.vertices
        result = []

        queue = []
        queue.append(start_vertex)
        visited[start_vertex] = True

        while queue:
            current_vertex = queue.pop(0)
            result.append(current_vertex)

            for neighbor in self.graph[current_vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
