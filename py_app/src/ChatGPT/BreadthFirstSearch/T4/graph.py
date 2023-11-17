from collections import defaultdict, deque

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        if u < 0 or u >= self.vertices or v < 0 or v >= self.vertices:
            raise ValueError("Invalid vertex index")
        self.graph[u].append(v)

    def bfs(self, start_vertex):
        if start_vertex < 0 or start_vertex >= self.vertices:
            raise ValueError("Invalid start vertex")

        visited = [False] * self.vertices
        result = []

        queue = deque()
        queue.append(start_vertex)
        visited[start_vertex] = True

        while queue:
            vertex = queue.popleft()
            result.append(vertex)

            for neighbor in self.graph[vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
