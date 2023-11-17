from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        if 1 <= u <= self.vertices and 1 <= v <= self.vertices:
            self.graph[u].append(v)

    def bfs(self, start_vertex):
        if 1 <= start_vertex <= self.vertices:
            visited = [False] * (self.vertices + 1)
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
        else:
            return []
