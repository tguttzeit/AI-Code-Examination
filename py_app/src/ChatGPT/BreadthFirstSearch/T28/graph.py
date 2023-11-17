from collections import deque

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for _ in range(vertices)]

    def add_edge(self, u, v):
        if 0 <= u < self.vertices and 0 <= v < self.vertices:
            self.adjacency_list[u].append(v)
            self.adjacency_list[v].append(u)

    def bfs(self, start_vertex):
        if 0 <= start_vertex < self.vertices:
            visited = [False] * self.vertices
            result = []

            queue = deque()
            queue.append(start_vertex)
            visited[start_vertex] = True

            while queue:
                current_vertex = queue.popleft()
                result.append(current_vertex)

                for neighbor in self.adjacency_list[current_vertex]:
                    if not visited[neighbor]:
                        queue.append(neighbor)
                        visited[neighbor] = True

            return result
        else:
            raise ValueError("Invalid start vertex")
