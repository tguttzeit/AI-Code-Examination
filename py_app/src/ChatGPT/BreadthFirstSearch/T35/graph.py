from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = defaultdict(list)

    def add_edge(self, u, v):
        self.adjacency_list[u].append(v)

    def bfs(self, start_vertex):
        visited = [False] * (self.vertices)
        result = []

        queue = []
        queue.append(start_vertex)
        visited[start_vertex] = True

        while queue:
            vertex = queue.pop(0)
            result.append(vertex)

            for neighbor in self.adjacency_list[vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
