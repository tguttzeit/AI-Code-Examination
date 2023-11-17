from collections import defaultdict, deque

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        if u < self.vertices and v < self.vertices:
            self.graph[u].append(v)

    def bfs(self, start_vertex):
        if start_vertex >= self.vertices:
            return []

        visited = [False] * self.vertices
        result = []
        queue = deque()

        visited[start_vertex] = True
        queue.append(start_vertex)

        while queue:
            vertex = queue.popleft()
            result.append(vertex)

            for neighbor in self.graph[vertex]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)

        return result
