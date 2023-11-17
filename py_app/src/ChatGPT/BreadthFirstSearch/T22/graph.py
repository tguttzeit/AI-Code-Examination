from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        if u < self.vertices and v < self.vertices:
            self.graph[u].append(v)
        else:
            raise ValueError("Vertices should be in the range [0, vertices-1]")

    def bfs(self, start_vertex):
        if start_vertex < self.vertices:
            visited = [False] * self.vertices
            queue = []
            result = []

            visited[start_vertex] = True
            queue.append(start_vertex)

            while queue:
                current_vertex = queue.pop(0)
                result.append(current_vertex)

                for neighbor in self.graph[current_vertex]:
                    if not visited[neighbor]:
                        visited[neighbor] = True
                        queue.append(neighbor)

            return result
        else:
            raise ValueError("Start vertex should be in the range [0, vertices-1]")
